/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.domainobjects;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author mayur
 */
@Entity
@Table(name = "TEACHER")
public class Teacher implements Serializable {
    @Id
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "BRANCH_ID")
    private Branch branchId;
    
    @OneToOne
    @JoinColumn(name = "LOGIN_ID")
    private Login loginId;
    
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "SHORT_NAME")
    private String shortName;
    
    

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

    
}
