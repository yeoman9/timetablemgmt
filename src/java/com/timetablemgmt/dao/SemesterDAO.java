/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.dao;

import com.timetablemgmt.domainobjects.Branch;
import com.timetablemgmt.domainobjects.Semester;
import java.util.List;

/**
 *
 * @author mayur
 */
public interface SemesterDAO {
    public Semester getById(Long id);
    public List<Semester> getAllSemesterByBranch(Branch branchId);
    public Semester saveOrUpdate(Semester semester);
}
