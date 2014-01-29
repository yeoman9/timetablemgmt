/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.dao.impl;

import com.timetablemgmt.dao.TeacherDAO;
import com.timetablemgmt.domainobjects.Branch;
import com.timetablemgmt.domainobjects.Teacher;
import static com.timetablemgmt.hibernateutils.HibernateUtil.getSessionFactory;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mayur
 */
@Repository
public class TeacherDAOImpl implements TeacherDAO{
    Session session = getSessionFactory().openSession();
    List<Teacher> teachers;
    
    @Override
    public List<Teacher> getAllTeachers() {
        try{
            teachers = session.createQuery("FROM Teacher").list();
        }catch(HibernateException ex){
        }
        return teachers;
    }

    @Override
    public List<Teacher> getTeachersByBranch(Branch branchId) {
        try{
            teachers = session.createQuery("FROM Teacher WHERE branchId.id '" + branchId.getId() + "'").list();
        }catch(HibernateException ex){
        }
        return teachers;
    }
    
    
}
