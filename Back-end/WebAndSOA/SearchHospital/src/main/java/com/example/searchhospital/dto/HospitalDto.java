package com.example.searchhospital.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HospitalDto
{
    @JsonProperty(value = "hospital_id")
    private Integer hospital_id;

    @JsonProperty(value = "name")
    private String name;

    public void setHospital_id(Integer hospital_id) {
        this.hospital_id = hospital_id;
    }

    @JsonProperty(value = "phone")
    private String phone;

    @JsonProperty(value = "type")
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty(value = "address")
    private String address;


    public Integer getHospital_id() {
        return hospital_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
