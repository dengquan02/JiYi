package com.example.manageuser.entity;

import java.io.Serializable;

/**
 * (DepartmentTotal)实体类
 *
 * @author makejava
 * @since 2022-05-14 14:36:48
 */
public class DepartmentTotal implements Serializable {

    private String departmentName;


    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

}
