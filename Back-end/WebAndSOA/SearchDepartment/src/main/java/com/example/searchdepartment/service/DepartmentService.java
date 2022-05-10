package com.example.searchdepartment.service;

import com.example.searchdepartment.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    //上传
    DepartmentDto uploadDepartment(DepartmentDto dto);

    //查询
    List<DepartmentDto> getDepartment(DepartmentDto dto);

    List<DepartmentDto> getDepartmentOne(DepartmentDto dto);

    DepartmentDto deletebyone(DepartmentDto dto);
}
