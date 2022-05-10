package com.example.manageuser.Service;

import com.example.manageuser.Dto.PatientDto;
import com.example.manageuser.Entity.Patient;

public interface PatientService
{
    // 删除
    PatientDto delete(PatientDto dto);

    // 编辑
    PatientDto edit(PatientDto dto);

    // 获取
    PatientDto get(String patient_id);
}
