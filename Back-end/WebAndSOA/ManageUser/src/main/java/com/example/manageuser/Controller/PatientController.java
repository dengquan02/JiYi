package com.example.manageuser.Controller;

import com.example.manageuser.Dto.PatientDto;
import com.example.manageuser.Service.PatientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "病人信息服务")
@RestController
@RequestMapping("api/v1/patient")
public class PatientController
{
    final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @ApiOperation("删除用户信息")
    @DeleteMapping("delete")
    public PatientDto Delete(@RequestBody PatientDto dto) {
        return patientService.delete ( dto );
    }

    @ApiOperation("编辑用户信息")
    @PutMapping("edit")
    public PatientDto Edit(@RequestBody PatientDto dto)
    {
        return patientService.edit ( dto );
    }

    @ApiOperation("获取用户信息")
    @GetMapping("get")
    public PatientDto Get(@RequestParam String patient_id)
    {
        return patientService.get ( patient_id );
    }
}