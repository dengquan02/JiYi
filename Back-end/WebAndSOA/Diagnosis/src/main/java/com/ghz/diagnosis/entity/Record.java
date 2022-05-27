package com.ghz.diagnosis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (Record)实体类
 *
 * @author makejava
 * @since 2022-05-14 15:55:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Record implements Serializable {
    private Integer recordId;

    private String patientId;

    private String doctorId;

    private String recordDate;

    private String complaint;

    private String check;

    private String drug;

    private String content;

    private String disable;

    private Integer attachment;

    private String judge;

    private Integer star;
}
