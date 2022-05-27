package com.example.login.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Doctor)实体类
 *
 * @author makejava
 * @since 2022-05-12 08:52:52
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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
