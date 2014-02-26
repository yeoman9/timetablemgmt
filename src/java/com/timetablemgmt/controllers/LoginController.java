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
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    Login loggedInUser;

    @RequestMapping(value = "/LoginAuth.htm")
    public ModelAndView loginAuth(@ModelAttribute(value = "loginAuth") Login login, HttpSession session, ModelAndView modelAndView ) {
        if (session.getAttribute("loggedInUser") == null) {
            loggedInUser = loginServiceIf.getLoginWithRole(login.getUsername(), login.getPassword());
            session.setAttribute("loggedInUser", loggedInUser);
        } else {
            loggedInUser = (Login) session.getAttribute("loggedInUser");
        }
        if (loggedInUser != null) {
            String userRole = loggedInUser.getUserRoleId().getRoleName();
            switch (userRole) {
                case "ROLE_CLERK":
                    branches = branchServiceIf.getAllBranches();
                    modelAndView.addObject("branches", branches);
                    modelAndView.addObject("color", Util.colors);
                    break;
                case "ROLE_PRINCIPAL":
                    branches = branchServiceIf.getAllBranches();
                    modelAndView.addObject("branches", branches);
                    modelAndView.addObject("branch", "active");
                    modelAndView.addObject("newBranch", new Branch());
                    break;
                case "ROLE_ADMIN":
                    principals = principalServiceIf.getPrincipalList();
                    modelAndView.addObject("principals", principals);
                    modelAndView.addObject("principal", "active");
                    modelAndView.addObject("newPrincipal", new Principal());
                    break;
            }
            modelAndView.setViewName(Util.getHomePageMappingFor(userRole));
        } else {
//            modelAndView.addObject("error", "true");
            modelAndView.setViewName("redirect:/retry.htm");
        }
        return modelAndView;
    }
}
