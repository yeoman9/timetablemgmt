/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.controllers;

import com.timetablemgmt.domainobjects.Login;
import com.timetablemgmt.services.LoginServiceIf;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author mayur
 */
@Controller
public class LoginController {

    @Autowired
    private LoginServiceIf loginServiceIf = null;

    @RequestMapping("/LoginAuth.htm")
    public ModelAndView loginAuth(@ModelAttribute(value = "loginAuth") Login login, HttpSession session, ModelAndView modelAndView) {
        if (session.getAttribute("loggedInUser") == null) {
            Login loggedInUser = loginServiceIf.getLoginWithRole(login.getUsername(), login.getPassword());
            if (loggedInUser != null) {
                session.setAttribute("loggedInUser", loggedInUser);
                modelAndView.setViewName("clerk/home");
            } else {
                modelAndView.addObject("loginAuth", new Login());
                modelAndView.addObject("error", "true");
                modelAndView.setViewName("index");
            }
            return modelAndView;
        } else {
            modelAndView.addObject("loginAuth", new Login());
            modelAndView.setViewName("index");
            return modelAndView;
        }
    }
}