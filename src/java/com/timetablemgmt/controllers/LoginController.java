/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.controllers;

import com.timetablemgmt.domainobjects.Branch;
import com.timetablemgmt.domainobjects.Login;
import com.timetablemgmt.domainobjects.Principal;
import com.timetablemgmt.services.BranchServiceIf;
import com.timetablemgmt.services.LoginServiceIf;
import com.timetablemgmt.services.PrincipalServiceIf;
import com.timetablemgmt.util.Util;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Autowired
    private BranchServiceIf branchServiceIf = null;
    @Autowired
    private PrincipalServiceIf principalServiceIf = null;
    List<Branch> branches = null;
    List<Principal> principals = null;
    
    @RequestMapping("/LoginAuth.htm")
    public ModelAndView loginAuth(@ModelAttribute(value = "loginAuth") Login login, HttpSession session, ModelAndView modelAndView) {
        if (session.getAttribute("loggedInUser") == null) {
            Login loggedInUser = loginServiceIf.getLoginWithRole(login.getUsername(), login.getPassword());
            if (loggedInUser != null) {
                session.setAttribute("loggedInUser", loggedInUser);
                String userRole = loggedInUser.getUserRoleId().getRoleName();
                if("ROLE_CLERK".equals(userRole)){
                    branches=branchServiceIf.getAllBranches();
                    modelAndView.addObject("branches", branches);
                    modelAndView.addObject("color", Util.colors);
                }
                else if("ROLE_PRINCIPAL".equals(userRole)){
                    branches=branchServiceIf.getAllBranches();
                    modelAndView.addObject("branches", branches);
                    modelAndView.addObject("newBranch", new Branch());
                }
                else if("ROLE_ADMIN".equals(userRole)){
                    principals=principalServiceIf.getPrincipalList();
                    modelAndView.addObject("principals", principals);
                    modelAndView.addObject("newPrincipal", new Principal());
                }
                modelAndView.setViewName(Util.getHomePageMappingFor(userRole));
            } else {
                modelAndView.addObject("loginAuth", new Login());
                modelAndView.addObject("error", "true");
                modelAndView.setViewName("index");
            }
            return modelAndView;
        } else {
            Login loggedInUser = (Login)session.getAttribute("loggedInUser");
            String userRole = loggedInUser.getUserRoleId().getRoleName();
            modelAndView.setViewName(Util.getHomePageMappingFor(userRole));
            return modelAndView;
        }
    }
}