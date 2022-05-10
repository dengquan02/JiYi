package com.example.reservation.service;



import com.example.reservation.dto.ReserveGetDto;

import java.util.List;

public interface ReserveService
{
    List<ReserveGetDto> getHistory(String patient_id);


    ReserveGetDto postReservation(ReserveGetDto dto);

    ReserveGetDto cancelReserve(ReserveGetDto dto);

    Integer delete(ReserveGetDto dto);
}
