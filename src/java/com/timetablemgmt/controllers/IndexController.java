/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.controllers;

import com.timetablemgmt.domainobjects.Branch;
import com.timetablemgmt.domainobjects.Login;
import com.timetablemgmt.domainobjects.UserRole;
import com.timetablemgmt.hibernateutils.HibernateUtil;
import javax.servlet.http.HttpSession;
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
    public ModelAndView indexHandler(HttpSession session, ModelAndView mav) {
        if (session.getAttribute("loggedInUser") == null) {
            HibernateUtil.getSessionFactory();
            mav.addObject("loginAuth", new Login());
            mav.setViewName("index");
            return mav;
        } else {
            Login loggedInUser = (Login)session.getAttribute("loggedInUser");
            loggedInUser.getUserRoleId().getRoleName();
            
            mav.setViewName("clerk/home");
            session.getAttribute("loggedInUser");
            return mav;
        }
    }

    @RequestMapping("/logout.htm")
    public ModelAndView logOut(HttpSession session, ModelAndView mav) {
        session.invalidate();
        mav.addObject("loginAuth", new Login());
        mav.setViewName("index");
        return mav;
    }
}