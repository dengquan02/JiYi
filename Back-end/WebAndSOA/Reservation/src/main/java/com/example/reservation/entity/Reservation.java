package com.example.reservation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (Reservation)实体类
 *
 * @author makejava
 * @since 2022-05-15 08:21:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation implements Serializable {
    private Integer reservationId;

    private String patientId;

    private String doctorId;

    private Integer rState;

    private String sysTime;

    private Integer hospitalId;

    private Integer departmentId;

    private Integer rYear;

    private Integer rMonth;

    private Integer rDay;

    private Integer rHour;

    private Integer rMinute;
}
