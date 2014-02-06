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
    public ModelAndView getTeacherList(@RequestParam Long id,ModelAndView mav){
        System.out.println("into controller..");
        
        
        if(id == 0){
            teachers = teacherServiceIf.getAllTeachers();
        }else{
            branchId = branchServiceIf.getByID(id);
            teachers = teacherServiceIf.getTeachersByBranch(branchId);
        }
        String active= "";
        System.out.println(teachers.get(0).getName());
        
        branches = branchServiceIf.getAllBranches();
        branchShortNames = new ArrayList<>();
        for(Branch branch : branches){
            branchShortNames.add(branch.getShortName());
        }
        
//
//        
//        Branch branch = new Branch();
//        branch.setId(1l);
//        
//        UserRole userRole = new UserRole();
//        userRole.setId(1l);
//
//        Login login = new Login();
//        login.setUserRoleId(userRole);
//        
//        Teacher teacher = new Teacher();
//        teacher.setLoginId(login);
//        teacher.setBranchId(branch);
        
        mav.addObject("teachers", teachers);
        mav.addObject("newTeacher",new Teacher());
        mav.addObject("branches",branchShortNames);
        
        mav.setViewName("clerk/clerk_teacherList");
//        mav.setViewName("hod/create_timetable");
        return mav;
    }
}
