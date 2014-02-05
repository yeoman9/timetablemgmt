/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.services;

import com.timetablemgmt.domainobjects.UserRole;

/**
 *
 * @author mayur
 */
public interface UserRoleServiceIf {
    public UserRole getByID(Long id);
}
