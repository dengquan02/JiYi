package com.example.signup.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DoctorDto
{
    @JsonProperty(value = "doctor_id")
    String doctor_id;

    @JsonProperty(value = "password")
    String password;

    @JsonProperty(value = "name")
    String name;

    @JsonProperty(value = "email")
    String email;

    @JsonProperty(value = "sex")
    String sex;

    @JsonProperty(value = "title")
    String title;

    @JsonProperty(value = "department_id")
    Integer department_id;

    @JsonProperty(value = "hospital_id")
    Integer hospital_id;

    // 默认用户不存在
    @JsonProperty(value = "ifExist")
    private Boolean ifExist = false;

    // 默认为合法
    @JsonProperty(value = "ifIllegal")
    private Boolean ifIllegal = true;

    // 默认为不存在
    @JsonProperty(value = "already")
    private Boolean already = false;

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
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

    public Integer getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(Integer hospital_id) {
        this.hospital_id = hospital_id;
    }
}
