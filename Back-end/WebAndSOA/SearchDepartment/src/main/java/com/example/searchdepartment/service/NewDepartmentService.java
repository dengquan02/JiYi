package com.example.searchdepartment.service;

import com.example.searchdepartment.dto.NewDepartmentDto;

import java.util.List;

/**
 * @author: Gu HungJou
 * @date: 2022/1/6 14:58
 * Describe:
 */
public interface NewDepartmentService {
    List<NewDepartmentDto> getDepartmentOne(NewDepartmentDto dto);
}
