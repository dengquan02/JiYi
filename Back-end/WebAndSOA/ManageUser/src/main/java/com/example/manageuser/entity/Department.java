package com.example.manageuser.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Department)实体类
 *
 * @author makejava
 * @since 2022-05-13 19:41:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department implements Serializable {

    private Integer departmentId;

    private String name;

    private Integer hospitalId;

    private String type;
}
