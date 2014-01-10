/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.timetablemgmt.hibernateutils.HibernateUtil;


/**
 *
 * @author mayur
 */
@Controller
public class LoginController {
    
    @RequestMapping("/test.htm")
    public String login() {
        HibernateUtil.getSessionFactory();
        System.out.println("inside Login Controller..");
        return "test";
    }
}
