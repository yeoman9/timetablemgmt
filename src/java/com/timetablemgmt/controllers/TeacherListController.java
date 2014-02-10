/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.controllers;

import com.timetablemgmt.domainobjects.Branch;
import com.timetablemgmt.domainobjects.Login;
import com.timetablemgmt.domainobjects.Teacher;
import com.timetablemgmt.domainobjects.UserRole;
import com.timetablemgmt.services.BranchServiceIf;
import com.timetablemgmt.services.TeacherServiceIf;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author mayur
 */
@Controller
public class TeacherListController {

    @Autowired
    private TeacherServiceIf teacherServiceIf = null;
    @Autowired
    private BranchServiceIf branchServiceIf = null;
    private List<Teacher> teachers;
    private List<Branch> branches;
    private List<String> branchShortNames;
    Branch branchId;

    @RequestMapping("/clerk_teacherList.htm")
    public ModelAndView getTeacherList(@RequestParam String branch, ModelAndView mav) {
        System.out.println("into controller..");


        if ("ALL".equals(branch)) {
            teachers = teacherServiceIf.getAllTeachers();

        } else {
            branchId = branchServiceIf.getByShortName(branch);
            if (branchId != null) {
                teachers = teacherServiceIf.getTeachersByBranch(branchId);
            }
        }

        branches = branchServiceIf.getAllBranches();
        branchShortNames = new ArrayList<>();

        for (Branch singleBranch : branches) {
            branchShortNames.add(singleBranch.getShortName());
        }

        mav.addObject("teachers", teachers);
        mav.addObject("newTeacher", new Teacher());
        mav.addObject("branches", branchShortNames);
        mav.addObject("branchShortName", branch);
        mav.setViewName("clerk/clerk_teacherList");
        return mav;
    }
}
