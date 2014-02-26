/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.services;

import com.timetablemgmt.domainobjects.Login;

/**
 *
 * @author mayur
 */
public interface LoginServiceIf {

    public Login getLogin(String username, String password);

    public Login getLoginWithRole(String username, String password);

    public Login getById(Long id);
}
