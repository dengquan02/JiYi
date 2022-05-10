package com.example.searchdepartment.controller;

import com.example.searchdepartment.dto.DepartmentDto;
import com.example.searchdepartment.dto.NewDepartmentDto;
import com.example.searchdepartment.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "部门信息服务")
@RequestMapping("api/v1/department")
public class DepartmentController {
    final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService){
        this.departmentService=departmentService;
    }

    @ApiOperation("上传部门信息请求")
    @PostMapping("upload")
    public ResponseEntity<DepartmentDto> departmentUpload(@RequestBody DepartmentDto dto){
        DepartmentDto upload=departmentService.uploadDepartment(dto);
        // 返回状态码201，表示注册了一个新的资源
        return new ResponseEntity<>(upload, HttpStatus.CREATED);
    }

    @ApiOperation("获得部门信息请求")
    @GetMapping("get")
    public ResponseEntity<List<DepartmentDto>> departmentGet(@RequestParam Integer department_id){
        DepartmentDto dto=new DepartmentDto();
        dto.setDepartment_id( department_id );
        List<DepartmentDto> get=departmentService.getDepartment(dto);
        return new ResponseEntity<> ( get, HttpStatus.OK );
    }

    @ApiOperation("获得部门信息请求")
    @GetMapping("get/one")
    public ResponseEntity<List<DepartmentDto>> departmentGetOne(@RequestParam Integer hospital_id){
        DepartmentDto dto=new DepartmentDto();
        dto.setHospital_id(hospital_id);
        List<DepartmentDto> get=departmentService.getDepartmentOne(dto);
        return new ResponseEntity<> ( get, HttpStatus.OK );
    }

    @ApiOperation("删除部门信息")
    @DeleteMapping("delete")
    public DepartmentDto Delete(@RequestBody DepartmentDto dto) {
        return departmentService.deletebyone ( dto );
    }

}
