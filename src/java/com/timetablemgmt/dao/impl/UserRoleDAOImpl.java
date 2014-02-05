/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.dao.impl;

import com.timetablemgmt.dao.UserRoleDAO;
import com.timetablemgmt.domainobjects.Branch;
import com.timetablemgmt.domainobjects.UserRole;
import static com.timetablemgmt.hibernateutils.HibernateUtil.getSessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mayur
 */
@Repository
public class UserRoleDAOImpl implements UserRoleDAO{

    @Override
    public UserRole getById(Long id) {
        Session session = getSessionFactory().openSession();
    try {
            System.out.println("yess returning userRole...");
             return (UserRole) session.createQuery("SELECT FROM UserRole WHERE id='" + id +"'");
             
        } catch (HibernateException e) {
        
        }finally{
            session.close();
        }
        return null;
    }
    
}
