/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.controllers;

import com.timetablemgmt.domainobjects.Login;
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
    @RequestMapping(value = "/index.htm")
    public ModelAndView indexHandler(HttpSession session, ModelAndView mav) {
        if (session.getAttribute("loggedInUser") == null) {
            mav.addObject("loginAuth", new Login());
            mav.setViewName("index");
            return mav;
        } else {
            mav.setViewName("redirect:/LoginAuth.htm");
            return mav;
        }
    }
    @RequestMapping(value = "/retry.htm")
    public ModelAndView reloginHandler(HttpSession session, ModelAndView mav) {
            mav.addObject("loginAuth", new Login());
            mav.addObject("error", "true");
            mav.setViewName("index");
            return mav;
    }

    @RequestMapping("/logout.htm")
    public ModelAndView logOut(HttpSession session, ModelAndView mav) {
        session.invalidate();
        mav.setViewName("redirect:/index.htm");
        return mav;
    }
}