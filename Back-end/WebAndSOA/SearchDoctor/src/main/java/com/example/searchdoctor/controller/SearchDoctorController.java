package com.example.searchdoctor.controller;

import com.example.searchdoctor.dto.DoctorDto;
import com.example.searchdoctor.dto.SearchDoctorDto;
import com.example.searchdoctor.service.SearchDoctorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "医生信息服务")
@RestController
@RequestMapping("api/v1/doctor")
public class SearchDoctorController {
    final SearchDoctorService doctorService;

    @Autowired
    public SearchDoctorController(SearchDoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @ApiOperation("上传医生信息")
    @PostMapping("upload")
    public ResponseEntity<SearchDoctorDto> doctorUpload(@RequestBody SearchDoctorDto dto){
        SearchDoctorDto upload=doctorService.uploadDoctor(dto);
        // 返回状态码201，表示注册了一个新的资源
        return new ResponseEntity<>(upload, HttpStatus.CREATED);
    }

    @ApiOperation("获取医生信息")
    @GetMapping("get")
    public ResponseEntity<List<SearchDoctorDto>> doctorGet(@RequestParam String doctor_id){
        SearchDoctorDto dto=new SearchDoctorDto();
        dto.setDoctor_id(doctor_id);
        List<SearchDoctorDto> get=doctorService.getDoctor(dto);
        return new ResponseEntity<> ( get, HttpStatus.OK );
    }


    @ApiOperation("通过部门获取医生请求")
    @GetMapping("get/one")
    public ResponseEntity<List<SearchDoctorDto>> departmentGetOne(@RequestParam Integer department_id){
        SearchDoctorDto dto=new SearchDoctorDto();
        dto.setDepartment_id(department_id);
        List<SearchDoctorDto> get=doctorService.getDoctorOne(dto);
        return new ResponseEntity<> ( get, HttpStatus.OK );
    }

    @ApiOperation("通过医院获取医生请求")
    @GetMapping("from/hospital")
    public ResponseEntity<List<SearchDoctorDto>> doctorFromHospital(@RequestParam Integer hospital_id) {
        SearchDoctorDto dto=new SearchDoctorDto();
        dto.setHospital_id(hospital_id);
        List<SearchDoctorDto> get=doctorService.getFromHospital(dto);
        return new ResponseEntity<> ( get, HttpStatus.OK );
    }

    @ApiOperation("获取全部医生请求")
    @GetMapping("all")
    public ResponseEntity<List<SearchDoctorDto>> doctorGetAll() {
        List<SearchDoctorDto> get = doctorService.getAllDoctor();
        return new ResponseEntity<> ( get, HttpStatus.OK );
    }

    @ApiOperation("获取某医生请求")
    @GetMapping("one")
    public ResponseEntity<DoctorDto> doctorGetOne(@RequestParam String doctor_id) {
        DoctorDto get = doctorService.getOne( doctor_id );
        return new ResponseEntity<> ( get, HttpStatus.OK );
    }

    @ApiOperation("患者端获取全部医生请求")
    @GetMapping("patient/all")
    public ResponseEntity<List<DoctorDto>> doctorGetAlla() {
        List<DoctorDto> get = doctorService.getAllDoctors();
        return new ResponseEntity<> ( get, HttpStatus.OK );
    }
}
