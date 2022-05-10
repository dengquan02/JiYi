package com.example.reservation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReserveGetDto
{
    @JsonProperty(value = "reservation_id")
    Integer reservation_id;

    @JsonProperty(value = "doctor")
    String doctor;

    @JsonProperty(value = "arrange_id")
    Integer arrange_id;

    @JsonProperty(value = "hospital")
    String hospital;

    @JsonProperty(value = "department")
    String department;

    @JsonProperty(value = "patient")
    String patient;

    @JsonProperty(value = "time")
    String time;

    @JsonProperty(value = "day")
    String day;

    @JsonProperty(value = "state")
    Integer state;

    public Integer getArrange_id() {
        return arrange_id;
    }

    public void setArrange_id(Integer arrange_id) {
        this.arrange_id = arrange_id;
    }

    public Integer getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(Integer reservation_id) {
        this.reservation_id = reservation_id;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
