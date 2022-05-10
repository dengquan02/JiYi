package com.example.login.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AdminDto {
    @JsonProperty(value = "admin_id")
    String admin_id;

    public String getAdmin_id() {
        return admin_id;
    }

    public Boolean getIfExist() {
        return ifExist;
    }

    public void setIfExist(Boolean ifExist) {
        this.ifExist = ifExist;
    }

    public Boolean getIfIllegal() {
        return ifIllegal;
    }

    public void setIfIllegal(Boolean ifIllegal) {
        this.ifIllegal = ifIllegal;
    }

    public Boolean getAlready() {
        return already;
    }

    public void setAlready(Boolean already) {
        this.already = already;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }

    // 默认用户不存在
    @JsonProperty(value = "ifExist")
    private Boolean ifExist = false;

    // 默认为合法
    @JsonProperty(value = "ifIllegal")
    private Boolean ifIllegal = true;

    // 默认为不存在
    @JsonProperty(value = "already")
    private Boolean already = false;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty(value = "password")
    String password;

    @JsonProperty(value = "name")
    String name;
}
