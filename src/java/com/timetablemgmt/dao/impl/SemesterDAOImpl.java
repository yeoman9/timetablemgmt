/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.dao.impl;

import com.timetablemgmt.common.QueryCriteria;
import com.timetablemgmt.common.QueryCriterion;
import com.timetablemgmt.dao.SemesterDAO;
import com.timetablemgmt.domainobjects.Branch;
import com.timetablemgmt.domainobjects.Semester;
import com.timetablemgmt.hibernateutils.BaseHibernateDAO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mayur
 */
@Repository
public class SemesterDAOImpl extends BaseHibernateDAO<Semester, Long> implements SemesterDAO{

    @Override
    public Semester getById(Long id) {
        return findById(id);
    }

    @Override
    public List<Semester> getAllSemesterByBranch(Branch branchId) {
        QueryCriteria criteria = new QueryCriteria();
        QueryCriterion criterion = QueryCriterion.createCriterion("coOrdinator.branchId.id", branchId.getId());
        criteria.addQueryCriteria("coOrdinator.branchId.id", criterion);
        return findEntities(criteria, true).getResults();
    }

    @Override
    public Semester saveOrUpdate(Semester semester) {
        return super.persist(semester);
    }
    
}
