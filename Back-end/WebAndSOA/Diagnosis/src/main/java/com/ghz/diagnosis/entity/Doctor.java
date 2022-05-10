package com.ghz.diagnosis.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Doctor implements Serializable {
    private String doctor_id;

    private String name;

    private String sex;

    private String title;

    private String password;

    private String email;

    private Integer department_id;

    private Integer hospital_id;

}
