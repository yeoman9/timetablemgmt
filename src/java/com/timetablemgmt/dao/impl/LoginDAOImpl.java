/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.dao.impl;

import com.timetablemgmt.common.QueryCriteria;
import com.timetablemgmt.common.QueryCriterion;
import com.timetablemgmt.dao.LoginDAO;
import com.timetablemgmt.domainobjects.Login;
import com.timetablemgmt.hibernateutils.BaseHibernateDAO;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mayur
 */
@Repository
public class LoginDAOImpl extends BaseHibernateDAO<Login, Long> implements LoginDAO {

    @Override
    public Login getLogin(String username, String password) {
        QueryCriteria criteria = new QueryCriteria();
        QueryCriterion criterion1 = QueryCriterion.createCriterion("username", username);
        QueryCriterion criterion2 = QueryCriterion.createCriterion("password", password);
        criteria.addQueryCriteria("username", criterion1);
        criteria.addQueryCriteria("password", criterion2);
        return findUniqueEntity(criteria, true);
    }
    @Override
    public Login getLoginWithRole(String username, String password) {
       
            Login login = getLogin(username, password);
            if(login!=null){
                Hibernate.initialize(login.getUserRoleId());
            }
        return login;
    }
}
