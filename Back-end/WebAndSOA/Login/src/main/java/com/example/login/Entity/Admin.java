package com.example.login.entity;

import java.io.Serializable;

/**
 * (Admin)实体类
 *
 * @author makejava
 * @since 2022-05-12 08:42:39
 */
public class Admin implements Serializable {

    private Integer adminId;

    private String name;

    private String password;


    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
