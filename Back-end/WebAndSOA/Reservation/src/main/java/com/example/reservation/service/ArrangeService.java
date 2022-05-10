package com.example.reservation.service;



import com.example.reservation.dto.ArrangeDto;
import com.example.reservation.dto.DoctorDto;
import com.example.reservation.dto.ReserveGetDto;

import java.util.List;

public interface ArrangeService
{
    List<DoctorDto> getAllDoctorByDay(String day, Integer hospital_id, Integer department_id);
    List<ArrangeDto> getReservation(String doctorId);
    List<ArrangeDto> getAllTimeByDoctorAndDay(String day, String doctor);
}
