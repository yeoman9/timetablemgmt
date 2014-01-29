/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.services;

import com.timetablemgmt.domainobjects.Login;
import org.springframework.stereotype.Service;

/**
 *
 * @author mayur
 */
public interface LoginServiceIf {

    public Login getLogin(String username, String password);
}
