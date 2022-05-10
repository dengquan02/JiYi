package com.example.signup.Service;

import com.example.signup.Dto.DoctorDto;
import com.example.signup.Dto.PatientDto;

public interface PatientService
{
    // 注册
    PatientDto register(PatientDto dto);
}
