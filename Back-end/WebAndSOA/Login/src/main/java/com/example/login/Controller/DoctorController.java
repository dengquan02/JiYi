package com.example.login.Controller;

import com.example.login.Dto.DoctorDto;
import com.example.login.Service.DoctorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "医生登录服务")
@RestController
@RequestMapping("api/v1/doctor")
public class DoctorController
{
    final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @ApiOperation("医生登录")
    @PostMapping("login")
    public ResponseEntity<DoctorDto> Login(@RequestBody DoctorDto dto) {
        return new ResponseEntity<>( doctorService.login ( dto ), HttpStatus.OK );
    }
}
