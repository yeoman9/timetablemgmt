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
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author mayur
 */
@Controller
public class AddOrUpdateTeacher {
    
    @Autowired
    private TeacherServiceIf teacherServiceIf= null;
    
    @Autowired
    private BranchServiceIf branchServiceIf= null;
    
    @Autowired
    private UserRoleServiceIf userRoleServiceIf = null;
    
    private List<Teacher> teachers;
    @RequestMapping("/addTeacher.htm")
    public ModelAndView addNewTeacher(@ModelAttribute(value = "newTeacher") Teacher teacher,@RequestParam ("selectedBranch") String branchShortName){
        ModelAndView modelAndView = new ModelAndView();
        String addInBranch = teacher.getBranchId().getShortName();
        teacher.setBranchId(branchServiceIf.getByShortName(addInBranch));
        teacher.getLoginId().setUserRoleId(userRoleServiceIf.getByID(4l));
        teacherServiceIf.saveOrUpdateTeacher(teacher);
        teachers = teacherServiceIf.getTeachersByBranch(branchServiceIf.getByShortName(branchShortName));
        modelAndView.addObject("teachers", teachers);
        modelAndView.addObject("newTeacher",new Teacher());
        modelAndView.addObject("branchShortName",branchShortName);
        modelAndView.setViewName("clerk/clerk_teacherList");
        
        return modelAndView;
    }
    
    @RequestMapping("/profile.htm")
    public String showProfile(@ModelAttribute(value = "newTeacher") Teacher teacher){

  //      teacherServiceIf.saveOrUpdateTeacher(teacher);
        return "teacher/profile";
    }
}
