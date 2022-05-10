package com.example.searchdepartment.controller;

import com.example.searchdepartment.dto.DepartmentDto;
import com.example.searchdepartment.dto.NewDepartmentDto;
import com.example.searchdepartment.service.NewDepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Gu HungJou
 * @date: 2022/1/6 14:56
 * Describe:
 */

@RestController
@Api(tags = "新部门信息服务")
@RequestMapping("api/v1/newdepartment")
public class NewDepartmentController {

    final NewDepartmentService newDepartmentService;

    @Autowired
    public NewDepartmentController(NewDepartmentService newDepartmentService){
        this.newDepartmentService=newDepartmentService;
    }

    @ApiOperation("获得部门信息请求")
    @GetMapping("/get/one")
    public ResponseEntity<List<NewDepartmentDto>> departmentGetOne(@RequestParam Integer hospital_id){
        NewDepartmentDto dto=new NewDepartmentDto();
        dto.setHospital_id(hospital_id);
        List<NewDepartmentDto> get=newDepartmentService.getDepartmentOne(dto);
        return new ResponseEntity<> ( get, HttpStatus.OK );
    }


}
