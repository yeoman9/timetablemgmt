/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.controllers;

import com.timetablemgmt.domainobjects.Branch;
import com.timetablemgmt.domainobjects.Login;
import com.timetablemgmt.domainobjects.UserRole;
import com.timetablemgmt.hibernateutils.HibernateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author mayur
 */
@Controller
public class IndexController {
    @RequestMapping("/index.htm")
    public ModelAndView indexHandler(){
        HibernateUtil.getSessionFactory();
        ModelAndView mav = new ModelAndView();

        mav.addObject("loginAuth",new Login());
        mav.setViewName("index");
        return mav;
    }
}