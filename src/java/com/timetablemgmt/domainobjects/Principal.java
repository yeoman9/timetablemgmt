/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.domainobjects;

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
@Table(name = "PRINCIPAL")
public class Principal {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "LOGIN_ID")
    private Login loginId;
    
    @Column(name = "NAME")
    private String name;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "COLLEGE_ID")
    private College collegeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public College getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(College collegeId) {
        this.collegeId = collegeId;
    }
    
    
}
