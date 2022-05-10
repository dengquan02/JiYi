package com.example.searchhospital.service;


import com.example.searchhospital.dto.HospitalDto;

import java.util.List;

public interface HospitalService {
    //上传
    HospitalDto uploadHospital(HospitalDto dto);

    //查询
    List<HospitalDto> getHospital(HospitalDto dto);


    List<HospitalDto> getAllHospital();

    // 删除
    HospitalDto delete(HospitalDto dto);


}
