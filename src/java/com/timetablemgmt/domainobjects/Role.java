/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.domainobjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author mayur
 */
@Entity
@Table(name = "ROLE")
public class Role {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @Column(name = "ROLE_NAME")
    private String roleName;
    @Column(name = "ROLE_DISPLAY_NAME")
    private String roleDisplayName;
    @Column(name = "ROLE_DISPLAY_ORDER")
    private Long roleDisplayOrder;
    @Column(name = "ROLE_HIERARCHY_ORDER")
    private Long roleHierarchyOrder;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDisplayName() {
        return roleDisplayName;
    }

    public void setRoleDisplayName(String roleDisplayName) {
        this.roleDisplayName = roleDisplayName;
    }

    public Long getRoleDisplayOrder() {
        return roleDisplayOrder;
    }

    public void setRoleDisplayOrder(Long roleDisplayOrder) {
        this.roleDisplayOrder = roleDisplayOrder;
    }

    public Long getRoleHierarchyOrder() {
        return roleHierarchyOrder;
    }

    public void setRoleHierarchyOrder(Long roleHierarchyOrder) {
        this.roleHierarchyOrder = roleHierarchyOrder;
    }
    
    
}
