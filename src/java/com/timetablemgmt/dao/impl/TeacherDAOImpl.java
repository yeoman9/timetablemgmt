/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.dao.impl;

import com.timetablemgmt.common.QueryCriteria;
import com.timetablemgmt.common.QueryCriterion;
import com.timetablemgmt.dao.TeacherDAO;
import com.timetablemgmt.domainobjects.Branch;
import com.timetablemgmt.domainobjects.Login;
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
//    Session session = getSessionFactory().openSession();
    
    List<Teacher> teachers;
    
    @Override
    public List<Teacher> getAllTeachers() {
        return getCurrentSession().createQuery("FROM Teacher").list();
    }

    @Override
    public List<Teacher> getTeachersByBranch(Branch branchId) {
        QueryCriteria criteria = new QueryCriteria();
        QueryCriterion criterion1 = QueryCriterion.createCriterion("branchId.id", branchId.getId());
        QueryCriterion criterion2 = QueryCriterion.createCriterion("hod",true, QueryCriterion.RESTRICTIONS.NE);
        criteria.addQueryCriteria("branchId.id", criterion1);
        criteria.addQueryCriteria("hod", criterion2);
        return findEntities(criteria,true).getResults();
    }

    @Override
    public Teacher saveOrUpdateTeacher(Teacher teacher) {
         return persist(teacher);
    }

    @Override
    public List<Teacher> getAllHods() {
        QueryCriteria criteria = new QueryCriteria();
        QueryCriterion criterion = QueryCriterion.createCriterion("hod",true);
        criteria.addQueryCriteria("hod", criterion);
        return findEntities(criteria,true).getResults();
    }

    @Override
    public Teacher getByLoginId(Login loginId) {
        QueryCriteria criteria = new QueryCriteria();
        QueryCriterion criterion = QueryCriterion.createCriterion("loginId.id", loginId.getId());
        criteria.addQueryCriteria("loginId.id", criterion);
        return findUniqueEntity(criteria,true);
    }

    @Override
    public Teacher getById(Long id) {
        return findById(id);
    }
    
    
}
