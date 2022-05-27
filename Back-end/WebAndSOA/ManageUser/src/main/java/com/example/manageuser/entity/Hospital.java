package com.example.manageuser.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Hospital)实体类
 *
 * @author makejava
 * @since 2022-05-13 19:40:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hospital implements Serializable {

    private Integer hospitalId;

    private String name;

    private String address;

    private String phone;

    private String type;

}
