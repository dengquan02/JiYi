package com.ghz.diagnosis.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Patient implements Serializable {
    private String patient_id;

    private String name;

    private Integer age;

    private String sex;

    private String password;

    private String email;
}
