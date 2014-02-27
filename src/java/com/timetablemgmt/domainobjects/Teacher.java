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
import javax.persistence.Transient;

/** 
 *
 * @author mayur
 */
@Entity
@Table(name = "TEACHER")
public class Teacher implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BRANCH_ID")
    private Branch branchId;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "LOGIN_ID")
    private Login loginId;
    
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "SHORT_NAME")
    private String shortName;

    @Column(name = "HOD",nullable = false, columnDefinition = "boolean default false")
    private Boolean hod;
    
    @Transient
    private String nameWithShortName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Branch getBranchId() {
        return branchId;
    }

    public void setBranchId(Branch branchId) {
        this.branchId = branchId;
    }

    public Login getLoginId() {
        return loginId;
    }

    public void setLoginId(Login loginId) {
        this.loginId = loginId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Boolean getHod() {
        return hod;
    }

    public void setHod(Boolean hod) {
        this.hod = hod;
    }

    public String getNameWithShortName() {
        return getName()+"   ("+getShortName()+")";
    }
    
}
