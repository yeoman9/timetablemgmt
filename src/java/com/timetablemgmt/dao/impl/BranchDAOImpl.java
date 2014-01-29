/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.dao.impl;

import com.timetablemgmt.dao.BranchDAO;
import com.timetablemgmt.domainobjects.Branch;
import static com.timetablemgmt.hibernateutils.HibernateUtil.getSessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mayur
 */
@Repository
public class BranchDAOImpl implements BranchDAO{
    Session session = getSessionFactory().openSession();
    
    @Override
    public Branch getById(Long id) {
        try {
             return (Branch) session.createQuery("SELECT FROM Branch WHERE id='" + id +"'");
             
        } catch (HibernateException e) {
        
        }finally{
            session.close();
        }
        return null;
    }

}
