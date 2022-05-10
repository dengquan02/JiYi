package com.example.searchhospital.controller;

import com.example.searchhospital.dao.HospitalDao;
import com.example.searchhospital.dto.HospitalDto;
import com.example.searchhospital.service.HospitalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.HashPrintJobAttributeSet;
import java.util.List;

@Api(tags = "医院信息服务")
@RestController
@RequestMapping("api/v1/hospital")
public class HospitalController {
    final HospitalService hospitalService;


    @Autowired
    public HospitalController(HospitalService hospitalService){
        this.hospitalService=hospitalService;
    }

    @ApiOperation("上传医院信息")
    @PostMapping("upload")
    public ResponseEntity<HospitalDto> hospitalUpload(@RequestBody HospitalDto dto){
        HospitalDto upload=hospitalService.uploadHospital(dto);
        // 返回状态码201，表示注册了一个新的资源
        return new ResponseEntity<>(upload,HttpStatus.CREATED);
    }

    @ApiOperation("获取医院信息")
    @GetMapping("get")
    public ResponseEntity<List<HospitalDto>> hospitalGet(@RequestParam Integer hospital_id){
        HospitalDto dto=new HospitalDto();
        dto.setHospital_id(hospital_id);
        List<HospitalDto> get=hospitalService.getHospital(dto);
        return new ResponseEntity<> ( get, HttpStatus.OK );
    }

    @ApiOperation("获取全部医院请求")
    @GetMapping("all")
    public ResponseEntity<List<HospitalDto>> hospitalGetAll() {
        List<HospitalDto> get = hospitalService.getAllHospital ();
        return new ResponseEntity<> ( get, HttpStatus.OK );
    }

    @ApiOperation("删除医院信息")
    @DeleteMapping("delete")
    public HospitalDto Delete(@RequestBody HospitalDto dto) {
        return hospitalService.delete ( dto );
    }

}
