package com.example.reservation.entity;

import javax.persistence.*;

@Entity
@Table(name="arrange")
public class Arrange
{
    @Id
    @Column(name="arrange_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer arrange_id;

    @Column(name="doctor_id")
    String doctor_id;

    @Column(name="day")
    String day;

    @Column(name="time")
    String time;

    @Column(name="left_ctn")
    Integer left_ctn;

    @Column(name="hospital_id")
    Integer hospital_id;

    @Column(name="department_id")
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
