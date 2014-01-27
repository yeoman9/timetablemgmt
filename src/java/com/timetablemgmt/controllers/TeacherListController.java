/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author mayur
 */
@Controller
public class TeacherListController {
    @RequestMapping("/teacherList.htm")
    public String getTeacherList(){
        System.out.println("into controller..");
        return "teacherList";
    }
}
