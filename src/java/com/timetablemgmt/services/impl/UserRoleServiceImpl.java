/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.services.impl;

import com.timetablemgmt.dao.UserRoleDAO;
import com.timetablemgmt.domainobjects.UserRole;
import com.timetablemgmt.services.UserRoleServiceIf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mayur
 */
@Service
public class UserRoleServiceImpl implements UserRoleServiceIf{
    @Autowired 
    private UserRoleDAO userRoleDAO = null;
    @Override
    public UserRole getByID(Long id) {
        return userRoleDAO.getById(id);
    }
}
