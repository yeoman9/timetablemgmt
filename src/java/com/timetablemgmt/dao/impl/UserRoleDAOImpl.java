/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.dao.impl;

import com.timetablemgmt.dao.UserRoleDAO;
import com.timetablemgmt.domainobjects.Branch;
import com.timetablemgmt.domainobjects.Login;
import com.timetablemgmt.domainobjects.UserRole;
import com.timetablemgmt.hibernateutils.BaseHibernateDAO;
import static com.timetablemgmt.hibernateutils.HibernateUtil.getSessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mayur
 */
@Repository
public class UserRoleDAOImpl extends BaseHibernateDAO<UserRole, Long> implements UserRoleDAO{

    @Override
    public UserRole getById(Long id) {
        return findById(id);
    }
    
}
