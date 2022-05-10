package com.example.searchdoctor.controller;

import com.example.searchdoctor.dto.NewDoctorDto;
import com.example.searchdoctor.service.NewDoctorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "新医生信息服务")
@RestController
@RequestMapping("api/v1/new")
public class NewDoctorController {
    final NewDoctorService newDoctorService;

    @Autowired
    public NewDoctorController(NewDoctorService newDoctorService) {
        this.newDoctorService = newDoctorService;
    }

    @ApiOperation("通过医院获取医生请求")
    @GetMapping("from/hospital")
    public ResponseEntity<List<NewDoctorDto>> doctorFromHospital(@RequestParam Integer hospital_id) {
        NewDoctorDto dto=new NewDoctorDto();
        dto.setHospital_id(hospital_id);
        List<NewDoctorDto> get=newDoctorService.getDoctorNew(dto);
        return new ResponseEntity<> ( get, HttpStatus.OK );
    }

}
