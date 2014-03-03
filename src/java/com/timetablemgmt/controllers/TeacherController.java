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
import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author mayur
 */
@Controller
public class TeacherController {
     
    @Autowired
    private TeacherServiceIf teacherServiceIf= null;
    
    @Autowired
    private BranchServiceIf branchServiceIf= null;
    
    @Autowired
    private UserRoleServiceIf userRoleServiceIf = null;
    
    private List<Branch> branches;
    private List<String> branchShortNames;
    Branch branchId;
    
    @InitBinder
	protected void initBinder(WebDataBinder binder)
	{
		binder.registerCustomEditor(Branch.class,new PropertyEditorSupport(){
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				try{
                                    Branch branch = branchServiceIf.getByID(Long.parseLong(text));
                                    System.out.println("-------------------"+text);    
				this.setValue(branch);
				}
				catch(Exception e){
				}
			}	
		});		
	} 
    
    private List<Teacher> teachers;
    @RequestMapping("/addTeacher.htm")
    public ModelAndView addNewTeacher(@ModelAttribute(value = "newTeacher") Teacher teacher,@RequestParam ("selectedBranch") String branchShortName){
        ModelAndView modelAndView = new ModelAndView();
//        String addInBranch = teacher.getBranchId().getShortName();
//        teacher.setBranchId(branchServiceIf.getByShortName(addInBranch));
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
    
    

    @RequestMapping("/clerk_teacherList.htm")
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
        branchShortNames = new ArrayList<>();

//        for (Branch singleBranch : branches) {
//            branchShortNames.add(singleBranch.getShortName());
//        }

        mav.addObject("teachers", teachers);
        mav.addObject("newTeacher", new Teacher());
        mav.addObject("branches", branches);
        mav.addObject("branchShortName", branch);
        mav.setViewName("clerk/clerk_teacherList");
        return mav;
    }
}
