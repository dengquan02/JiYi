package com.example.signup.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Doctor)实体类
 *
 * @author makejava
 * @since 2022-05-13 17:57:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor implements Serializable {

    private String doctorId;

    private String name;

    private String password;

    private String sex;

    private String title;

    private Integer departmentId;

    private String email;

    private Integer hospitalId;

    private Integer reserveCtn;

    private byte[] pic;
}
