package com.example.login.Controller;

import com.example.login.Dto.PatientDto;
import com.example.login.Service.PatientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "病人登录服务")
@RestController
@RequestMapping("api/v1/patient")
public class PatientController
{
    final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @ApiOperation("病人登录")
    @PostMapping("login")
    public ResponseEntity<PatientDto> Login(@RequestBody PatientDto dto) {
        return new ResponseEntity<>( patientService.login ( dto ), HttpStatus.OK );
    }
}