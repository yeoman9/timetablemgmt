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
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.validator.internal.constraintvalidators.SizeValidatorForMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author mayur
 */
@Controller
public class AddOrUpdateTeacher {
    
    @Autowired
    private TeacherServiceIf teacherServiceIf= null;
    @Autowired
    private UserRoleServiceIf userRoleServiceIf = null;
    @RequestMapping("/addTeacher.htm")
    public String addNewTeacher(@ModelAttribute(value = "newTeacher") Teacher teacher){
////        Teacher teacher = new Teacher();
        UserRole r = new UserRole();
        r.setId(1l);
//        Branch b = new Branch();
//        b.setId(1l);
//        Login l = new Login();
//        l.setId(3l);
//        teacher.setBranchId(b);
//        teacher.setLoginId(l);
        teacher.getLoginId().setUserRoleId(r);
//        
////        teacher.get
        System.out.println("inside add new teacher..");
        System.out.println("Branch : "+teacher.getBranchId() +"Name :"+teacher.getBranchId().getShortName());        
        System.out.println("Login : "+teacher.getLoginId()+"Name :"+teacher.getLoginId().getEmail());        
        System.out.println("UserRole : "+teacher.getLoginId().getUserRoleId()/*+"Name :"+teacher.getLoginId().getUserRoleId().getRoleName()*/);        
        teacherServiceIf.saveOrUpdateTeacher(teacher);
//        
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        UserRole role = new UserRole();
//        Transaction tx = session.beginTransaction();
//        role.setRoleName("MAyur");
//        session.save(role);
//        tx.commit();
        return "clerk/clerk_teacherList";
    }
}
