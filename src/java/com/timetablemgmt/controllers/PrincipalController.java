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
<<<<<<< HEAD
import java.util.AbstractList;
=======
import com.timetablemgmt.util.Util;
>>>>>>> 1745bcaf630672ef8cbf44bc9b3ed3d15c85cd22
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.ResponseBody;
=======
>>>>>>> 1745bcaf630672ef8cbf44bc9b3ed3d15c85cd22
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
<<<<<<< HEAD
    List<Teacher> listOfTeachers = null;
    List<String> listOfTeacherShortNames = null;
    
=======
    Map<Long,Teacher> hods= null;
    Branch branchId;
>>>>>>> 1745bcaf630672ef8cbf44bc9b3ed3d15c85cd22
    @RequestMapping("/hod.htm")
    public ModelAndView getTeacherList(ModelAndView mav) {
        hodList = teacherServiceIf.getAllHod();
        branches = branchServiceIf.getAllBranches();
        List<String> branchShortNames = new ArrayList<>();

        for (Branch singleBranch : branches) {
            branchShortNames.add(singleBranch.getShortName());
        }
<<<<<<< HEAD
        
        listOfTeachers = teacherServiceIf.getTeachersByBranch(branches.get(0));
        listOfTeacherShortNames = new ArrayList<>();
        for(Teacher teacher:listOfTeachers){
            listOfTeacherShortNames.add(teacher.getNameWithShortName());
        }
        
        mav.addObject("hods", hodList);
        mav.addObject("teachers", listOfTeachers);
        mav.addObject("teacherShortNames", listOfTeacherShortNames);
=======
        hods = new HashMap<>();
        hodList = teacherServiceIf.getAllHod();
                    for(Teacher hodTemp: hodList){
                        hods.put(hodTemp.getBranchId().getId(), hodTemp);
                    }
                    System.out.println("Hod MAP : "+hods);
                    
        mav.addObject("hods", hods);
>>>>>>> 1745bcaf630672ef8cbf44bc9b3ed3d15c85cd22
        mav.addObject("newHod", new Teacher());
        mav.addObject("branches", branches);
        mav.addObject("color", Util.colors);
        mav.addObject("hod", "active");
        mav.setViewName("principal/sidebar/hod");
        return mav;
    }

//    @RequestMapping("/addHod.htm")
//    public ModelAndView addTimeSlot(@ModelAttribute(value = "newHod") Teacher hod) {
//        ModelAndView mav = new ModelAndView();
//        String addInBranch = hod.getBranchId().getShortName();
//        hod.setBranchId(branchServiceIf.getByShortName(addInBranch));
//        hod.getLoginId().setUserRoleId(userRoleServiceIf.getByID(3l));
//        teacherServiceIf.saveOrUpdateTeacher(hod);
//        hodList = new ArrayList<>();
//        hodList = teacherServiceIf.getAllHod();
//        mav.addObject("hods", hodList);
//        mav.addObject("hod", "active");
//        mav.addObject("newHod", new Teacher());
//        mav.setViewName("principal/sidebar/hod");
//        return mav;
//    }
    
    @RequestMapping("ajaxTeacherList.htm")
    @ResponseBody
    public List<String> ajaxTeacherList(@ModelAttribute(value = "newHod") Teacher hod,@RequestParam(value = "branchSelected")String branch) {
        System.out.println("Branchh Name----"+branch);
        Branch branchId = branchServiceIf.getByShortName(branch);
        System.out.println("Branchh----"+branchId);
        hodList = teacherServiceIf.getTeachersByBranch(branchId);
  //      return "sanket";
        listOfTeacherShortNames = new ArrayList<>();
        listOfTeachers = teacherServiceIf.getTeachersByBranch(branchId);
        
        for(Teacher teacher:listOfTeachers){
            listOfTeacherShortNames.add(teacher.getNameWithShortName());
        }
        return listOfTeacherShortNames;
        
    }
    
    @RequestMapping("saveAsHod.htm")
    public ModelAndView saveAsHod(@ModelAttribute(value = "newHod")Teacher teacher) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("------"+teacher.getName());
        
        String nameWithShortname = teacher.getName();
        
        
        return modelAndView;
        
        
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
