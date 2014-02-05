/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.services.impl;

import com.timetablemgmt.dao.LoginDAO;
import com.timetablemgmt.domainobjects.Login;
import com.timetablemgmt.services.LoginServiceIf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mayur
 */
@Service
public class LoginServiceImpl implements LoginServiceIf{
    @Autowired 
    private LoginDAO loginDAO = null;
    @Override
    public Login getLogin(String username, String password) {
       return loginDAO.getLogin(username,password);
    }

    @Override
    public Login getLoginWithRole(String username, String password) {
               return loginDAO.getLoginWithRole(username,password);
    }
    
}
