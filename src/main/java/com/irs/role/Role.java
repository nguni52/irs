/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.irs.role;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author nkululekophakela
 */
@Entity
@Table(name = "role", uniqueConstraints = {@UniqueConstraint(columnNames = {"description"})})
public class Role implements Serializable {
    @Id
    @Column(name = "role_id")
    @GeneratedValue
    private int roleId;
    @Column(name="description")
    private String description;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Role{" + "roleId=" + roleId + ", roleDescription=" + description + '}';
    }
}
