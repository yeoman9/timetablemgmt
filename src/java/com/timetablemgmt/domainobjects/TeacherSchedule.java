/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.domainobjects;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author sanket
 */
@Entity
@Table(name = "TEACHER_SCHEDULE")
public class TeacherSchedule implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TEACHER")
    private Teacher teacher;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BRANCH")
    private Branch branch;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SEMESTER")
    private Semester semester;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SUBJECT")
    private Subject subject;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TIME_SLOT")
    private TimeSlot timeSlot;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }
    
}
