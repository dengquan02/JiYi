package com.example.searchdoctor.entity;

import javax.persistence.*;

@Entity
@Table(name="hospital")
public class Hospital {
    @Id
    @Column(name="hospital_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer hospital_id;

    @Column(name="name")
    String name;

    public void setHospital_id(Integer hospital_id) {
        this.hospital_id = hospital_id;
    }

    @Column(name="address")
    String address;

    @Column(name="phone")
    String phone;

    @Column(name="type")
    String type;

    public Integer getHospital_id() {
        return hospital_id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
