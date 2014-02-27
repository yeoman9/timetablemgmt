/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.controllers;

import com.timetablemgmt.domainobjects.Branch;
import com.timetablemgmt.domainobjects.Login;
import com.timetablemgmt.domainobjects.Semester;
import com.timetablemgmt.domainobjects.Teacher;
import com.timetablemgmt.services.SemesterServiceIf;
import com.timetablemgmt.services.TeacherServiceIf;
import java.beans.PropertyEditorSupport;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author sanket
 */
@Controller
public class SemesterController {

    List<Semester> semesters = null;
    List<Teacher> coOrdinators = null;
    @Autowired
    private SemesterServiceIf semesterServiceIf = null;
    
    @Autowired
    private TeacherServiceIf teacherServiceIf = null;

    
    
    @RequestMapping("/addSemester.htm")
    public ModelAndView addSemester(@ModelAttribute(value = "newSemester") Semester semester) {
        ModelAndView modelAndView = new ModelAndView();
        
        semesterServiceIf.saveOrUpdate(semester);
        Branch branch = semester.getCoOrdinator().getBranchId();
        semesters = semesterServiceIf.getAllSemesterByBranch(branch);
        coOrdinators = teacherServiceIf.getTeachersByBranch(branch);
        modelAndView.addObject("semesters", semesters);
        modelAndView.addObject("coOrdinators", coOrdinators);
        modelAndView.addObject("semester", "active");
        modelAndView.addObject("newSemester", new Semester());
        modelAndView.setViewName("hod/sidebar/semester");

        return modelAndView;
    }
    
    @InitBinder
	protected void initBinder(WebDataBinder binder)
	{
		binder.registerCustomEditor(Teacher.class,new PropertyEditorSupport(){
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				try{
                                    
                                    Teacher teacher = teacherServiceIf.getById(Long.parseLong(text));
                                    System.out.println("-------------------"+text);    
//				Date dateObj=DateUtil.toDate(text);				
//				logger.info("Now Setter called"+text);
				this.setValue(teacher);
				}
				catch(Exception e){
//					logger.error(e.getMessage(),e);
				}
			}	
		});		
	} 
    
}
