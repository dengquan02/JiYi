package com.example.searchdoctor.service;

import com.example.searchdoctor.dto.DoctorDto;
import com.example.searchdoctor.dto.SearchDoctorDto;

import java.util.List;

public interface SearchDoctorService {

    //上传
    SearchDoctorDto uploadDoctor(SearchDoctorDto dto);

    //查询
    List<SearchDoctorDto> getDoctor(SearchDoctorDto dto);


    List<SearchDoctorDto> getDoctorOne(SearchDoctorDto dto);

    List<SearchDoctorDto> getFromHospital(SearchDoctorDto dto);

    List<SearchDoctorDto> getAllDoctor();

    List<DoctorDto> getAllDoctors();

    DoctorDto getOne(String doctor_id );
}
