/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.services.impl;

import com.timetablemgmt.dao.BranchDAO;
import com.timetablemgmt.dao.TeacherDAO;
import com.timetablemgmt.domainobjects.Branch;
import com.timetablemgmt.services.BranchServiceIf;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mayur
 */
@Service
public class BranchServiceImpl implements BranchServiceIf{
    @Autowired 
    private BranchDAO branchDAO = null;
    @Autowired
    private  TeacherDAO teacherDAO = null;
    @Override
    public Branch getByID(Long id) {
        return branchDAO.getById(id);
    }

    @Override
    public List<Branch> getAllBranches() {
        List<Branch> branches = branchDAO.getAllBranches();
        for(Branch b : branches ){
            b.setTotal(teacherDAO.getTeachersByBranch(b).size());
        }
        return branches;
    }

    @Override
    public Branch getByShortName(String shortName) {
        return branchDAO.getByShortName(shortName);
    }
    
}
