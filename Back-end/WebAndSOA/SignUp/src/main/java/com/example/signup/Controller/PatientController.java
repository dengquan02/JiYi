package com.example.signup.Controller;

import com.example.signup.Dto.DoctorDto;
import com.example.signup.Dto.PatientDto;
import com.example.signup.Service.DoctorService;
import com.example.signup.Service.PatientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户信息服务")
@RestController
@RequestMapping("api/v1/patient")
public class PatientController
{
    final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @ApiOperation("注册")
    @PostMapping("register")
    public ResponseEntity<PatientDto> Register(@RequestBody PatientDto dto) {
        PatientDto register = patientService.register ( dto );
        if (register.getIfExist ())
            return new ResponseEntity<> ( register, HttpStatus.OK );
        // 返回状态码201，表示注册了一个新的资源
        return new ResponseEntity<> ( register, HttpStatus.CREATED );
    }
}
