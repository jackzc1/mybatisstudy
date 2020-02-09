package com.soft.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2020/2/9.
 */
public class Role implements Serializable {

    private Integer id;
    private String roleName;
    private String roleDesc;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public Role(Integer id, String roleName, String roleDesc) {

        this.id = id;
        this.roleName = roleName;
        this.roleDesc = roleDesc;
    }

    public Role() {

    }
}
