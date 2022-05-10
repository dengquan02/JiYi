package com.example.searchdepartment.entity;

import javax.persistence.*;

/**
 * @author: Gu HungJou
 * @date: 2022/1/6 14:57
 * Describe:
 */

@Entity
@Table(name="newdepartment")
public class NewDepartment {
    @Id
    @Column(name="department_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer department_id;

    @Column(name="name")
    String name;

    @Column(name="type")
    String type;

    @Column(name="hospital_id")
    Integer hospital_id;

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
