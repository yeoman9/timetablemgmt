/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.controllers;

import com.timetablemgmt.domainobjects.Branch;
import com.timetablemgmt.domainobjects.Login;
import com.timetablemgmt.domainobjects.Teacher;
import com.timetablemgmt.domainobjects.UserRole;
import com.timetablemgmt.hibernateutils.HibernateUtil;
import com.timetablemgmt.services.TeacherServiceIf;
import com.timetablemgmt.services.UserRoleServiceIf;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.validator.internal.constraintvalidators.SizeValidatorForMap;
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
public class AddOrUpdateTeacher {
    
    @Autowired
    private TeacherServiceIf teacherServiceIf= null;
    
    private List<Teacher> teachers;
    @RequestMapping("/addTeacher.htm")
    public ModelAndView addNewTeacher(@ModelAttribute(value = "newTeacher") Teacher teacher){
        ModelAndView modelAndView = new ModelAndView();
        teacherServiceIf.saveOrUpdateTeacher(teacher);
        teachers = teacherServiceIf.getAllTeachers();
        modelAndView.addObject("teachers", teachers);
        modelAndView.addObject("newTeacher",new Teacher());
        modelAndView.setViewName("clerk/clerk_teacherList");
        
        return modelAndView;
    }
    
    @RequestMapping("/profile.htm")
    public String showProfile(@ModelAttribute(value = "newTeacher") Teacher teacher){

  //      teacherServiceIf.saveOrUpdateTeacher(teacher);
        return "teacher/profile";
    }
}
