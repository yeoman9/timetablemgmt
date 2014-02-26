/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.dao;

import com.timetablemgmt.domainobjects.Login;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mayur
 */

public interface LoginDAO {

    public Login getLogin(String username, String password);
    public Login getLoginWithRole(String username, String password);

    public Login getById(Long id);
    
}
