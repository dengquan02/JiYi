package com.example.manageuser.controller;

import com.example.manageuser.entity.Hospital;
import com.example.manageuser.service.DoctorService;
import com.example.manageuser.service.HospitalService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * (Hospital)表控制层
 *
 * @author makejava
 * @since 2022-05-13 19:40:38
 */
@RestController
@RequestMapping("/hospitalManage")
public class HospitalController {
    /**
     * 服务对象
     */
    @Resource
    private HospitalService hospitalService;


    @ApiOperation(value = "获取单个医院信息", notes = "返回医院信息")
    @ApiResponses({
//            @ApiResponse(code = 438, message = "用户id or 邮箱 or 密码错误"),
//            @ApiResponse(code = 440, message = "无效请求")
    })
    @GetMapping("getHospital/{id}")
    public Object getHospital(@PathVariable Integer id, HttpServletResponse response) {
        Hospital hospital = this.hospitalService.queryById(id);
        if(hospital!=null) return hospital;
        else return -1;
    }

    @ApiOperation(value = "获取所有医院信息", notes = "")
    @ApiResponses({
//            @ApiResponse(code = 438, message = "用户id or 邮箱 or 密码错误"),
//            @ApiResponse(code = 440, message = "无效请求")
    })
    @GetMapping("getAllHospital")
    public Object getAllHospital(HttpServletResponse response) {
        List<Hospital> hospitals = this.hospitalService.queryAll();
        if(hospitals!=null) return hospitals;
        else return -1;
    }

    @ApiOperation(value = "删除医院", notes = "-1、-2失败")
    @ApiResponses({
//            @ApiResponse(code = 438, message = "用户id or 邮箱 or 密码错误"),
//            @ApiResponse(code = 440, message = "无效请求")
    })
    @GetMapping("deleteHospital/{id}")
    public Object deleteHospital(@PathVariable Integer id, HttpServletResponse response) {
        if (id != null) {
            try {
                this.hospitalService.queryById(id);
            } catch (Exception e) {
                return -1;
            }
        } else {
            response.setStatus(440);
            return null;
        }
        boolean b = this.hospitalService.deleteById(id);
        if (b)
            return 1;
        else return -2;
    }

    @ApiOperation(value = "新增医院", notes = "")
    @ApiResponses({
//            @ApiResponse(code = 438, message = "用户id or 邮箱 or 密码错误"),
//            @ApiResponse(code = 440, message = "无效请求")
    })
    @PostMapping("addHospital")
    public Object addHospital(@RequestParam Integer id,
                              @RequestParam String name,
                              @RequestParam String address,
                              @RequestParam String phone,
                              String type,
                              HttpServletResponse response) {
       Hospital hospital=new Hospital(id,name,address,phone,type);
       return hospitalService.insert(hospital);
    }

    @ApiOperation(value = "修改医院", notes = "")
    @ApiResponses({
//            @ApiResponse(code = 438, message = "用户id or 邮箱 or 密码错误"),
//            @ApiResponse(code = 440, message = "无效请求")
    })
    @PostMapping("modifyHospital")
    public Object modifyHospital(@RequestParam Integer id,
                                 String name,
                                 String address,
                                 String phone,
                                 String type,
                                 HttpServletResponse response) {
        Hospital hospital=hospitalService.queryById(id);
        if(name!=null&&!name.equals("")){
            hospital.setName(name);
        }
        if(address!=null&&!address.equals("")){
            hospital.setAddress(address);
        }
        if(phone!=null&&!phone.equals("")){
            hospital.setPhone(phone);
        }
        if(type!=null&&!type.equals("")){
            hospital.setType(type);
        }
        return hospitalService.update(hospital);
    }

}
