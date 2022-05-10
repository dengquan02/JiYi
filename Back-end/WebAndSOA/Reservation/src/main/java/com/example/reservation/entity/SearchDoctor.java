package com.example.reservation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="doctor")
public class SearchDoctor {

    @Id
    @Column(name="doctor_id")
    String doctor_id;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public void setHospital_id(Integer hospital_id) {
        this.hospital_id = hospital_id;
    }

    @Column(name="name")
    String name;

    @Column(name="password")
    String password;

    @Column(name="sex")
    String sex;

    @Column(name="title")
    String title;

    @Column(name="email")
    String email;

    @Column(name="department_id")
    Integer department_id;

    @Column(name="hospital_id")
    Integer hospital_id;

    @Column(name="reserve_ctn")
    Integer reserve_ctn;

    public Integer getDepartment_id() {
        return department_id;
    }

    public Integer getHospital_id() {
        return hospital_id;
    }

    public Integer getReserve_ctn() {
        return reserve_ctn;
    }

    public void setReserve_ctn(Integer reserve_ctn) {
        this.reserve_ctn = reserve_ctn;
    }
}
