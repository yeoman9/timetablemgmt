/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.dao.impl;

import com.timetablemgmt.dao.LoginDAO;
import com.timetablemgmt.domainobjects.Login;
import com.timetablemgmt.hibernateutils.BaseHibernateDAO;
import com.timetablemgmt.hibernateutils.HibernateUtil;
import java.io.Serializable;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mayur
 */
@Repository
public class LoginDAOImpl extends BaseHibernateDAO<Login, Long> implements LoginDAO {

    @Override
    public Login getLogin(String username, String password) {
        //Session session = getSessionFactory().openSession();
        Login login = null;
        try {
            login = (Login) getCurrentSession().createQuery("FROM Login WHERE username = '" + username + "' AND password = '" + password + "'").uniqueResult();
        } catch (HibernateException e) {
        } finally {
            //session.close();
        }
        return login;
    }
    @Override
    public Login getLoginWithRole(String username, String password) {
       // Session session = getSessionFactory().openSession();
        Login login = null;
        try {
            login = (Login) getCurrentSession().createQuery("FROM Login WHERE username = '" + username + "' AND password = '" + password + "'").uniqueResult();
            if(login!=null)
            Hibernate.initialize(login.getUserRoleId());
        } catch (HibernateException e) {
        } finally {
           // session.close();
        }
        return login;
    }
}
