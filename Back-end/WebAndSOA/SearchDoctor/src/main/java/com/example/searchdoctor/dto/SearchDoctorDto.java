package com.example.searchdoctor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchDoctorDto {

    @JsonProperty(value = "doctor_id")
    private String doctor_id;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "sex")
    private String sex;

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public Integer getHospital_id() {
        return hospital_id;
    }

    @JsonProperty(value = "title")
    private String title;

    @JsonProperty(value = "password")
    private String password;

    @JsonProperty(value = "email")
    private String email;

    @JsonProperty(value = "department_id")
    private Integer department_id;

    @JsonProperty(value = "hospital_id")
    private Integer hospital_id;

    @JsonProperty(value = "reserve_ctn")
    private Integer reserve_ctn;

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public void setHospital_id(Integer hospital_id) {
        this.hospital_id = hospital_id;
    }

    public Integer getReserve_ctn() {
        return reserve_ctn;
    }

    public void setReserve_ctn(Integer reserve_ctn) {
        this.reserve_ctn = reserve_ctn;
    }

}
