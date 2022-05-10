package com.example.signup.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PatientDto
{
    @JsonProperty(value = "patient_id")
    String patient_id;

    @JsonProperty(value = "password")
    String password;

    @JsonProperty(value = "name")
    String name;

    @JsonProperty(value = "email")
    String email;

    @JsonProperty(value = "sex")
    String sex;

    @JsonProperty(value = "idcard")
    String idcard;

    @JsonProperty(value = "age")
    Integer age;

    // 默认用户不存在
    @JsonProperty(value = "ifExist")
    private Boolean ifExist = false;

    // 默认为合法
    @JsonProperty(value = "ifIllegal")
    private Boolean ifIllegal = true;

    // 默认为不存在
    @JsonProperty(value = "already")
    private Boolean already = false;

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }
}
