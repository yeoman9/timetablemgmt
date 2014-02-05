/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.services.impl;

import com.timetablemgmt.dao.TeacherDAO;
import com.timetablemgmt.domainobjects.Branch;
import com.timetablemgmt.domainobjects.Teacher;
import com.timetablemgmt.services.TeacherServiceIf;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mayur
 */
@Service
public class TeacherServiceImpl implements TeacherServiceIf{
    @Autowired
    private TeacherDAO teacherDAO = null;

    @Override
    public List<Teacher> getAllTeachers() {
            return teacherDAO.getAllTeachers();
    }

    @Override
    public List<Teacher> getTeachersByBranch(Branch branchId) {
            return teacherDAO.getTeachersByBranch(branchId);
    }

    @Override
    public Teacher saveOrUpdateTeacher(Teacher teacher) {
            return teacherDAO.saveOrUpdateTeacher(teacher);
    }
}
