package com.example.reservation.entity;

import javax.persistence.*;

@Entity
@Table(name="reservation")
public class Reserve
{
    @Id
    @Column(name="reservation_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer reservation_id;

    @Column(name="doctor")
    String doctor;

    @Column(name="hospital")
    String hospital;

    @Column(name="department")
    String department;

    @Column(name="patient")
    String patient;

    @Column(name="time")
    String time;

    @Column(name="day")
    String day;

    @Column(name="state")
    Integer state;

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
