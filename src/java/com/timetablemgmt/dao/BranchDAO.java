/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.dao;

import com.timetablemgmt.domainobjects.Branch;
import java.util.List;

/**
 *
 * @author mayur
 */
public interface BranchDAO {
    public Branch getById(Long id);

    public Branch getByShortName(String shortName);

    public List<Branch> getAllBranches();
}
