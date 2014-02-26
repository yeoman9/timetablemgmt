/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.services.impl;

import com.timetablemgmt.dao.SemesterDAO;
import com.timetablemgmt.domainobjects.Branch;
import com.timetablemgmt.domainobjects.Semester;
import com.timetablemgmt.services.SemesterServiceIf;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mayur
 */
@Service
public class SemesterServiceImpl implements SemesterServiceIf {

    @Autowired
    private SemesterDAO semesterDAO = null;

    @Override
    public Semester getById(Long id) {
        return semesterDAO.getById(id);
    }
    
    @Override
    public List<Semester> getAllSemesterByBranch(Branch branchId) {
        return semesterDAO.getAllSemesterByBranch(branchId);
    }
}
