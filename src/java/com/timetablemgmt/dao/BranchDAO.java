/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.dao;

import com.timetablemgmt.domainobjects.Branch;

/**
 *
 * @author mayur
 */
public interface BranchDAO {
        
    public Branch getById(Long id);

}
