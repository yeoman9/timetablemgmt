/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.controllers;

import com.timetablemgmt.domainobjects.Branch;
import com.timetablemgmt.domainobjects.Teacher;
import com.timetablemgmt.services.BranchServiceIf;
import com.timetablemgmt.services.TeacherServiceIf;
import com.timetablemgmt.services.UserRoleServiceIf;
import com.timetablemgmt.util.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    @Autowired
    private UserRoleServiceIf userRoleServiceIf = null;
    List<Teacher> hodList = null;
    List<Branch> branches = null;
    Map<Long,Teacher> hods= null;
    Branch branchId;
    @RequestMapping("/hod.htm")
    public ModelAndView getTeacherList(ModelAndView mav) {
        hodList = teacherServiceIf.getAllHod();
        branches = branchServiceIf.getAllBranches();
        List<String> branchShortNames = new ArrayList<>();

        for (Branch singleBranch : branches) {
            branchShortNames.add(singleBranch.getShortName());
        }
        hods = new HashMap<>();
        hodList = teacherServiceIf.getAllHod();
                    for(Teacher hodTemp: hodList){
                        hods.put(hodTemp.getBranchId().getId(), hodTemp);
                    }
                    System.out.println("Hod MAP : "+hods);
                    
        mav.addObject("hods", hods);
        mav.addObject("newHod", new Teacher());
        mav.addObject("branches", branches);
        mav.addObject("color", Util.colors);
        mav.addObject("hod", "active");
        mav.setViewName("principal/sidebar/hod");
        return mav;
    }

    @RequestMapping("/addHod.htm")
    public ModelAndView addTimeSlot(@ModelAttribute(value = "newHod") Teacher hod) {
        ModelAndView mav = new ModelAndView();
        String addInBranch = hod.getBranchId().getShortName();
        hod.setBranchId(branchServiceIf.getByShortName(addInBranch));
        hod.getLoginId().setUserRoleId(userRoleServiceIf.getByID(3l));
        teacherServiceIf.saveOrUpdateTeacher(hod);
        hodList = new ArrayList<>();
        hodList = teacherServiceIf.getAllHod();
        mav.addObject("hods", hodList);
        mav.addObject("hod", "active");
        mav.addObject("newHod", new Teacher());
        mav.setViewName("principal/sidebar/hod");
        return mav;
    }
    
    @RequestMapping("/teachers.htm")
    public ModelAndView getTeacherList(@RequestParam String branch, ModelAndView mav) {
        System.out.println("into controller..");

        List<Teacher> teachers = null;
        if ("ALL".equals(branch)) {
            teachers = teacherServiceIf.getAllTeachers();

        } else {
            branchId = branchServiceIf.getByShortName(branch);
            if (branchId != null) {
                teachers = teacherServiceIf.getTeachersByBranch(branchId);
            }
        }

        branches = branchServiceIf.getAllBranches();

//        for (Branch singleBranch : branches) {
//            branchShortNames.add(singleBranch.getShortName());
//        }

        mav.addObject("teachers", teachers);
        mav.addObject("newTeacher", new Teacher());
        mav.addObject("branches", branches);
        mav.addObject("branchShortName", branch);
        mav.setViewName("principal/principal_teacherList");
        return mav;
    }
}
