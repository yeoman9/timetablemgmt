/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.services;

import com.timetablemgmt.domainobjects.Branch;
import com.timetablemgmt.domainobjects.Semester;
import java.util.List;

/**
 *
 * @author mayur
 */
public interface SemesterServiceIf {
    public Semester getById(Long id);
    public List<Semester> getAllSemesterByBranch(Branch branchId);
}
