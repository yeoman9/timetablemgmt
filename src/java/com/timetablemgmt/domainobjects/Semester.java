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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author sanket
 */
@Entity
@Table(name = "SEMESTER")
public class Semester implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "SEMESTER_NO")
    private int  semesterNo;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "COORDINATOR")
    private Teacher coOrdinator;
    
    @Column(name = "DIVISION")
    private int  division;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSemesterNo() {
        return semesterNo;
    }

    public void setSemesterNo(int semesterNo) {
        this.semesterNo = semesterNo;
    }

    public Teacher getCoOrdinator() {
        return coOrdinator;
    }

    public void setCoOrdinator(Teacher coOrdinator) {
        this.coOrdinator = coOrdinator;
    }
    
    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }
    
}
