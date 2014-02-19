/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.dao.impl;

import com.timetablemgmt.dao.PrincipalDAO;
import com.timetablemgmt.domainobjects.Principal;
import com.timetablemgmt.hibernateutils.BaseHibernateDAO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mayur
 */
@Repository
public class PrincipalDAOImpl extends BaseHibernateDAO<Principal, Long> implements PrincipalDAO{

    @Override
    public List<Principal> getPrincipalList() {
        return getCurrentSession().createQuery("FROM Principal").list();
    }
    
}
