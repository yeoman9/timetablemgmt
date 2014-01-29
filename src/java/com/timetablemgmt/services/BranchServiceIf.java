/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.services;

import com.timetablemgmt.domainobjects.Branch;

/**
 *
 * @author mayur
 */
public interface BranchServiceIf {
    public Branch getByID(Long id);
}
