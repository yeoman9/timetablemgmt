/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.dao.impl;

import com.timetablemgmt.common.QueryCriteria;
import com.timetablemgmt.common.QueryCriterion;
import com.timetablemgmt.dao.TeacherDAO;
import com.timetablemgmt.domainobjects.Branch;
import com.timetablemgmt.domainobjects.Teacher;
import com.timetablemgmt.hibernateutils.BaseHibernateDAO;
import com.timetablemgmt.hibernateutils.BasicHiberDAO;
import static com.timetablemgmt.hibernateutils.HibernateUtil.getSessionFactory;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mayur
 */
@Repository
public class TeacherDAOImpl extends BaseHibernateDAO<Teacher, Long>implements TeacherDAO{
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
        QueryCriteria criteria = new QueryCriteria();
        QueryCriterion criterion = QueryCriterion.createCriterion("branchId.id", branchId.getId());
        criteria.addQueryCriteria("branchId.id", criterion);
        return findEntities(criteria,true).getResults();
    }

    @Override
    public Teacher saveOrUpdateTeacher(Teacher teacher) {
         return persist(teacher);
    }
    
    
}
