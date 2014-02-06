/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.services;

import com.timetablemgmt.domainobjects.Branch;
import java.util.List;

/**
 *
 * @author mayur
 */
public interface BranchServiceIf {
    public Branch getByID(Long id);
    public List<Branch> getAllBranches();
    public Branch getByShortName(String shortName);

}
