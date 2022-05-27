package com.example.manageuser.controller;

import com.example.manageuser.entity.Department;
import com.example.manageuser.entity.Patient;
import com.example.manageuser.service.PatientService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Patient)表控制层
 *
 * @author makejava
 * @since 2022-05-13 19:36:33
 */
@RestController
@RequestMapping("/patientManage")
public class PatientController {
    /**
     * 服务对象
     */
    @Resource
    private PatientService patientService;

    @ApiOperation(value = "获取患者信息", notes = "返回user信息")
    @ApiResponses({
//            @ApiResponse(code = 438, message = "用户id or 邮箱 or 密码错误"),
            @ApiResponse(code = 440, message = "无效请求")
    })
    @GetMapping("getPatientInfo/{id}")
    public Object getPatientInfo(@PathVariable String id, HttpServletResponse response) {
        Patient patient;
        if (id != null && !id.equals("")) {
            patient = this.patientService.queryById(id);
        } else {
            response.setStatus(440);
            return null;
        }
        //进行Base64编码
//        String pic=null;
//        if(patient.getPic()!=null){
//            BASE64Encoder encoder = new BASE64Encoder();
//            pic = encoder.encode(patient.getPic());
//        }

        Map<String, Object> map = new HashMap<>();
        map.put("patientId", patient.getPatientId());
        map.put("patientName", patient.getName());
        map.put("patientEmail", patient.getEmail());
        map.put("patientSex", patient.getSex());
        map.put("patientAge", patient.getAge());
//        map.put("pic", pic);
        map.put("patientIdCard", patient.getIdcard());
        return map;
    }

    @ApiOperation(value = "获取患者信息-单个", notes = "返回user信息;pic为base64编码")
    @ApiResponses({
//            @ApiResponse(code = 438, message = "用户id or 邮箱 or 密码错误"),
            @ApiResponse(code = 440, message = "无效请求")
    })
    @GetMapping("getPatient/{id}")
    public Object getPatient(@PathVariable String id, HttpServletResponse response) {
        Patient patient;
        if (id != null && !id.equals("")) {
            patient = this.patientService.queryById(id);
        } else {
            response.setStatus(440);
            return null;
        }
        //进行Base64编码
        String pic=null;
        if(patient.getPic()!=null){
            BASE64Encoder encoder = new BASE64Encoder();
            pic = encoder.encode(patient.getPic());
        }

        Map<String, Object> map = new HashMap<>();
        map.put("patientId", patient.getPatientId());
        map.put("patientName", patient.getName());
        map.put("patientEmail", patient.getEmail());
        map.put("patientSex", patient.getSex());
        map.put("patientAge", patient.getAge());
        map.put("pic", pic);
        map.put("patientIdCard", patient.getIdcard());
        return map;
    }
    @ApiOperation(value = "删除单个患者", notes = "-1 id无效，-2删除失败")
    @ApiResponses({
//            @ApiResponse(code = 438, message = "用户id or 邮箱 or 密码错误"),
            @ApiResponse(code = 440, message = "无效请求")
    })
    @GetMapping("deletePatient/{id}")
    public Object deletePatientcvc(@PathVariable String id, HttpServletResponse response) {
        if (id != null && !id.equals("")) {
            try {
                this.patientService.queryById(id);
            } catch (Exception e) {
                return -1;
            }
        } else {
            response.setStatus(440);
            return null;
        }
        boolean b = this.patientService.deleteById(id);
        if (b)
            return 1;
        else return -2;
    }
    @ApiOperation(value = "获取所有患者", notes = "返回user信息;pic为base64编码")
    @ApiResponses({
//            @ApiResponse(code = 438, message = "用户id or 邮箱 or 密码错误"),
//            @ApiResponse(code = 440, message = "无效请求")
    })
    @GetMapping("getAllPatient")
    public Object getAllPatient(HttpServletResponse response) {
        List<Patient> patients = this.patientService.queryAll();
        List list = new ArrayList();
        for (Patient patient : patients) {
            Map<String, Object> map = new HashMap<>();
            map.put("patientId", patient.getPatientId());
            map.put("patientName", patient.getName());
            map.put("patientEmail", patient.getEmail());
            map.put("patientSex", patient.getSex());
            map.put("patientAge", patient.getAge());
            //进行Base64编码
            String pic=null;
            if(patient.getPic()!=null){
                BASE64Encoder encoder = new BASE64Encoder();
                pic = encoder.encode(patient.getPic());
            }
            map.put("pic", pic);
            map.put("patientIdCard", patient.getIdcard());
            list.add(map);
        }

        return list;
    }


}
