package com.example.searchdoctor.service;

import com.example.searchdoctor.dto.NewDoctorDto;

import java.util.List;

public interface NewDoctorService {
    List<NewDoctorDto> getDoctorNew(NewDoctorDto dto);
}
