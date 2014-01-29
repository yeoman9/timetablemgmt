/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.controllers;

import com.timetablemgmt.domainobjects.Branch;
import com.timetablemgmt.domainobjects.Teacher;
import com.timetablemgmt.services.BranchServiceIf;
import com.timetablemgmt.services.TeacherServiceIf;
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
    Branch branchId;
    
    @RequestMapping("/clerk_teacherList.htm")
    public ModelAndView getTeacherList(@RequestParam Long id,ModelAndView mav){
        System.out.println("into controller..");
        
        
        if(id == 0){
            teachers = teacherServiceIf.getAllTeachers();
        }else{
            branchId = branchServiceIf.getByID(id);
            teachers = teacherServiceIf.getTeachersByBranch(branchId);
        }
        System.out.println(teachers.get(0).getName());
        mav.addObject("teachers", teachers);
        mav.setViewName("clerk/clerk_teacherList");
        return mav;
    }
}
