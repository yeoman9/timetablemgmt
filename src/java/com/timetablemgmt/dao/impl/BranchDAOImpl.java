/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.dao.impl;

import com.timetablemgmt.common.QueryCriteria;
import com.timetablemgmt.common.QueryCriterion;
import com.timetablemgmt.dao.BranchDAO;
import com.timetablemgmt.domainobjects.Branch;
import com.timetablemgmt.hibernateutils.BaseHibernateDAO;
import static com.timetablemgmt.hibernateutils.HibernateUtil.getSessionFactory;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mayur
 */
@Repository
public class BranchDAOImpl extends BaseHibernateDAO<Branch, Long> implements BranchDAO{
    
    @Override
    public Branch getById(Long id) {
        return findById(id);
    }

    @Override
    public List<Branch> getAllBranches() {
        return getCurrentSession().createQuery("FROM Branch").list();
    }

    @Override
    public Branch getByShortName(String shortName) {
        QueryCriteria criteria = new QueryCriteria();
        QueryCriterion criterion = QueryCriterion.createCriterion("shortName", shortName);
        criteria.addQueryCriteria("shortName", criterion);
        return findUniqueEntity(criteria, true);
    }

    @Override
    public Branch saveOrUpdateBranch(Branch branch) {
        return super.persist(branch);
    }

}
