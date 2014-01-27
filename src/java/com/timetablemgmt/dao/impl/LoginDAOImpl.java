/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.dao.impl;

import com.timetablemgmt.dao.LoginDAO;
import com.timetablemgmt.domainobjects.Login;
import com.timetablemgmt.hibernateutils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mayur
 */
@Repository
public class LoginDAOImpl extends HibernateUtil implements LoginDAO {

    @Override
    public Login getLogin(String username, String password) {
        Session session = getSessionFactory().openSession();
//        Transaction tx = null;
        Login login = null;
        try {
//            tx = session.beginTransaction();
            login = (Login) session.createQuery("FROM Login where username = '" + username + "' AND password = '" + password + "'").uniqueResult();
             
//            tx.commit();
        } catch (HibernateException e) {
//            if (tx != null) {
//                tx.rollback();
//            }
        } finally {
            session.close();
        }
        return login;
    }
}
