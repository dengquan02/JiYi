package com.example.reservation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DoctorDto
{
    @JsonProperty(value = "title")
    private String title;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "department")
    private String department;

    @JsonProperty(value = "hospital")
    private String hospital;

    @JsonProperty(value = "price")
    private Integer price;

    @JsonProperty(value = "sex")
    private String sex;

    @JsonProperty(value = "id")
    private String id;

    @JsonProperty(value = "ctn")
    private Integer ctn;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCtn() {
        return ctn;
    }

    public void setCtn(Integer ctn) {
        this.ctn = ctn;
    }
}
