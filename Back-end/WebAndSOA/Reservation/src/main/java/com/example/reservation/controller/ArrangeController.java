package com.example.reservation.controller;

import com.example.reservation.dto.ArrangeDto;
import com.example.reservation.dto.DoctorDto;
import com.example.reservation.service.ArrangeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/arrange")
public class ArrangeController
{
    final ArrangeService arrangeService;

    @Autowired
    public ArrangeController(ArrangeService arrangeService){
        this.arrangeService=arrangeService;
    }


    @GetMapping("get")
    public ResponseEntity<List<DoctorDto>> getAllDoctors(@RequestParam String day, @RequestParam Integer hospital_id, @RequestParam Integer department_id){
        List<DoctorDto> get=arrangeService.getAllDoctorByDay(day, hospital_id, department_id);
        return new ResponseEntity<>( get, HttpStatus.OK );
    }

    @GetMapping("get/one")
    public ResponseEntity<List<ArrangeDto>> getDoctor(@RequestParam String day, @RequestParam String doctor){
        List<ArrangeDto> get=arrangeService.getAllTimeByDoctorAndDay(day, doctor);
        return new ResponseEntity<>( get, HttpStatus.OK );
    }

    @ApiOperation("医生获取预约信息")
    @GetMapping("/doctorGet")
    public List<MyCalender> doctorGet(@RequestParam String doctorId){
        List<ArrangeDto> get=arrangeService.getReservation(doctorId);
        List<MyCalender> list=new ArrayList<>();
        for(ArrangeDto ad:get){
            MyCalender myCalender=new MyCalender();
            myCalender.setArrangeId(String.valueOf(ad.getArrange_id()));
            myCalender.setYuliang(String.valueOf(ad.getLeft_ctn()));
            String year=ad.getDay();
            year=year.replace("年","-");
            year=year.replace("月","-");
            year=year.replace("日"," ");
            String t=ad.getTime();
            String[] tt=t.split("~");
            String startTime=year+tt[0]+":00";
            String endTime=year+tt[1]+":00";
            myCalender.setStartTime(startTime);
            myCalender.setEndTime(endTime);
            list.add(myCalender);
        }
        return list;
    }
}
