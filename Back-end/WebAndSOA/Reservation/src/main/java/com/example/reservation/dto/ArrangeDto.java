package com.example.reservation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ArrangeDto
{
    @JsonProperty(value="arrange_id")
    Integer arrange_id;

    @JsonProperty(value="doctor_id")
    String doctor_id;

    @JsonProperty(value="day")
    String day;

    @JsonProperty(value="time")
    String time;

    @JsonProperty(value="left_ctn")
    Integer left_ctn;

    @JsonProperty(value="hospital_id")
    Integer hospital_id;

    @JsonProperty(value="department_id")
    Integer department_id;

    public Integer getArrange_id() {
        return arrange_id;
    }

    public void setArrange_id(Integer arrange_id) {
        this.arrange_id = arrange_id;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getLeft_ctn() {
        return left_ctn;
    }

    public void setLeft_ctn(Integer left_ctn) {
        this.left_ctn = left_ctn;
    }

    public Integer getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(Integer hospital_id) {
        this.hospital_id = hospital_id;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }
}
