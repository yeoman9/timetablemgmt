/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.dao;

import com.timetablemgmt.domainobjects.Branch;
import com.timetablemgmt.domainobjects.Login;
import com.timetablemgmt.domainobjects.Teacher;
import java.util.List;

/**
 *
 * @author mayur
 */
public interface TeacherDAO {
    
    public Teacher getById(Long id);

    public List<Teacher> getAllTeachers();

    public List<Teacher> getTeachersByBranch(Branch branchId);

    public Teacher saveOrUpdateTeacher(Teacher teacher);

    public List<Teacher> getAllHods();

    public Teacher getByLoginId(Login loginId);
}
