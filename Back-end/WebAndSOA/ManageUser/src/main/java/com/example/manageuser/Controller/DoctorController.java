package com.example.manageuser.Controller;

import com.example.manageuser.Dto.DoctorDto;
import com.example.manageuser.Service.DoctorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "医生信息服务")
@RestController
@RequestMapping("api/v1/doctor")
public class DoctorController
{
    final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @ApiOperation("删除医生信息")
    @DeleteMapping("delete")
    public DoctorDto Delete(@RequestBody DoctorDto dto) {
        return doctorService.delete ( dto );
    }

    @ApiOperation("编辑医生信息")
    @PutMapping("edit")
    public DoctorDto Edit(@RequestBody DoctorDto dto) { return doctorService.edit ( dto ); }


    @ApiOperation("通过医院删除医生信息")
    @DeleteMapping("delete/one")
    public DoctorDto DeleteByOne(@RequestBody DoctorDto dto) {
        return doctorService.deletebyone ( dto );
    }


}
