package com.ghz.diagnosis.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Gu HungJou
 * @date: 2022/1/6 9:20
 * Describe:
 */
@NoArgsConstructor
@Data
public class ReturnData {
    private String doctorName;

    private String hospitalName;

    private String DepartName;

    private Integer recordId;

    private String patientId;

    private String doctorId;

    private String content;

    private String date;
}
