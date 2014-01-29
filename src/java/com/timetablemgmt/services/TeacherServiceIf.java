/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.services;

import com.timetablemgmt.dao.TeacherDAO;
import com.timetablemgmt.domainobjects.Branch;
import com.timetablemgmt.domainobjects.Teacher;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mayur
 */
public interface TeacherServiceIf {

    public List<Teacher> getAllTeachers();

    public List<Teacher> getTeachersByBranch(Branch branchId);
}
