package com.example.searchdepartment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author: Gu HungJou
 * @date: 2022/1/6 14:57
 * Describe:
 */
public class NewDepartmentDto {
    @JsonProperty(value = "department_id")
    private Integer department_id;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "type")
    private String type;

    @JsonProperty(value = "hospital_id")
    private Integer hospital_id;

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(Integer hospital_id) {
        this.hospital_id = hospital_id;
    }
}
