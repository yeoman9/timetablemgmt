/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.controllers;

import com.timetablemgmt.domainobjects.Branch;
import com.timetablemgmt.services.BranchServiceIf;
import java.util.List;
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
public class BranchController {
    @Autowired
    private BranchServiceIf branchServiceIf = null;
    List<Branch> branches = null;

    @RequestMapping("/addBranch.htm")
    public ModelAndView addBranch(@ModelAttribute(value = "newBranch") Branch branch) {
        ModelAndView mav = new ModelAndView();
        branchServiceIf.saveOrUpdateBranch(branch);
        branches = branchServiceIf.getAllBranches();
        mav.addObject("branches", branches);
        mav.addObject("newBranch", new Branch());
        mav.setViewName("principal/home");
        return mav;
    }
}
