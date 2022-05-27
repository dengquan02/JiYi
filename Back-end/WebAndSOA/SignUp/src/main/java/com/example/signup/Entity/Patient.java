package com.example.signup.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Patient)实体类
 *
 * @author makejava
 * @since 2022-05-13 07:09:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient implements Serializable {

    private String patientId;

    private String name;

    private Integer age;

    private String sex;

    private String password;

    private String email;

    private String idcard;

    private byte[] pic;

}
