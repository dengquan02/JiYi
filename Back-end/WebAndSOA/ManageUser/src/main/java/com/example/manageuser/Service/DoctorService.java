package com.example.manageuser.Service;

import com.example.manageuser.Dto.DoctorDto;

public interface DoctorService
{
    // 删除
    DoctorDto delete(DoctorDto dto);

    // 通过医院删除
    DoctorDto deletebyone(DoctorDto dto);

    // 编辑
    DoctorDto edit(DoctorDto dto);
}
