package com.example.reservation.controller;

import com.example.reservation.dto.ReserveGetDto;
import com.example.reservation.service.ReserveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "预约服务")
@RequestMapping("api/v1/reservation")
@CrossOrigin("*")
public class ReservationController {
    final ReserveService mReserveService;


    @Autowired
    public ReservationController(ReserveService reserveService) {
        mReserveService = reserveService;
    }

    @ApiOperation("插入预约请求")
    @PostMapping("upload")
    public ResponseEntity<ReserveGetDto> reserveUpload(@RequestBody ReserveGetDto dto){
        ReserveGetDto upload=mReserveService.postReservation(dto);
        // 返回状态码201，表示注册了一个新的资源
        return new ResponseEntity<>(upload, HttpStatus.CREATED);
    }

    @ApiOperation("取消预约请求")
    @PostMapping("cancel")
    public ReserveGetDto Edit(@RequestBody ReserveGetDto dto) { return mReserveService.cancelReserve ( dto ); }

    @ApiOperation("获取全部预约")
    @GetMapping("get")
    public ResponseEntity<List<ReserveGetDto>> getAllDoctors(@RequestParam String patient){
        List<ReserveGetDto> get=mReserveService.getHistory(patient);
        return new ResponseEntity<>( get, HttpStatus.OK );
    }


    @ApiOperation("删除预约订单")
    @DeleteMapping("delete")
    public Integer Delete(@RequestBody ReserveGetDto dto) {
        return mReserveService.delete ( dto );
    }

}
