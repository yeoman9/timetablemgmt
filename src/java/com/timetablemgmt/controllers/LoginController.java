/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.controllers;

import com.timetablemgmt.domainobjects.Login;
import com.timetablemgmt.services.LoginServiceIf;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author mayur
 */
@Controller
public class LoginController {
    @Autowired 
    private LoginServiceIf loginServiceIf = null;
//    @RequestMapping("/home.htm")
//    public String login(HttpServletRequest request,
//                        @RequestParam(value = "username", required = false) String username, 
//                        @RequestParam(value = "password", required = false) String password) {
////        Logger logger = Logger.getLogger(LoginController.class);
////        logger.debug("yes logger is working...");
//        System.out.println(username + " ============= " + password);
//        
//        Login login = loginServiceIf.getLogin(username, password);
//        
//        System.out.println("Role : "+login.getUserRoleId().getRoleName());
//        return "clerk/home";
//    }
    
    @RequestMapping("/LoginAuth.htm")
    public ModelAndView loginAuth(@ModelAttribute(value = "loginAuth")Login login){
        System.out.println("inside cooooool");
        Login loggedInUser = loginServiceIf.getLoginWithRole(login.getUsername(), login.getPassword());
        ModelAndView modelAndView = new ModelAndView();
        if(loggedInUser!=null){
            modelAndView.addObject("loggedInUserName",loggedInUser.getUsername());
            modelAndView.setViewName("clerk/home");
        }
        else{
            modelAndView.addObject("error","true");
            modelAndView.setViewName("index");
        }
            return modelAndView;
    }
}