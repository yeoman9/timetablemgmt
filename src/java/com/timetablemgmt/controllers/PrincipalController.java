/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.controllers;

import com.timetablemgmt.domainobjects.Branch;
import com.timetablemgmt.domainobjects.Teacher;
import com.timetablemgmt.domainobjects.TimeSlot;
import com.timetablemgmt.services.BranchServiceIf;
import com.timetablemgmt.services.TeacherServiceIf;
import java.util.ArrayList;
import java.util.List;
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
public class PrincipalController {

    @Autowired
    private TeacherServiceIf teacherServiceIf = null;
    @Autowired
    private BranchServiceIf branchServiceIf = null;
    List<Teacher> hodList = null;
    List<Branch> branches = null;

    @RequestMapping("/hod.htm")
    public ModelAndView getTeacherList(ModelAndView mav) {
        hodList = teacherServiceIf.getAllHod();
        branches = branchServiceIf.getAllBranches();
        List<String> branchShortNames = new ArrayList<>();

        for (Branch singleBranch : branches) {
            branchShortNames.add(singleBranch.getShortName());
        }
        mav.addObject("hods", hodList);
        mav.addObject("newHod", new Teacher());
        mav.addObject("branches", branchShortNames);
        mav.addObject("hod", "active");
        mav.setViewName("principal/sidebar/hod");
        return mav;
    }

    @RequestMapping("/addHod.htm")
    public ModelAndView addTimeSlot(@ModelAttribute(value = "newHod") Teacher hod) {
        ModelAndView mav = new ModelAndView();
        teacherServiceIf.saveOrUpdateTeacher(hod);
        hodList = new ArrayList<>();
        hodList = teacherServiceIf.getAllHod();
        mav.addObject("hods", hodList);
        mav.addObject("newHod", new Teacher());
        mav.setViewName("principal/sidebar/hod");
        return mav;
    }
}
