package com.example.manageuser.controller;

import com.example.manageuser.entity.Department;
import com.example.manageuser.entity.Doctor;
import com.example.manageuser.entity.Hospital;
import com.example.manageuser.service.DepartmentService;
import com.example.manageuser.service.DoctorService;
import com.example.manageuser.service.HospitalService;
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
 * (Doctor)表控制层
 *
 * @author makejava
 * @since 2022-05-13 19:36:00
 */
@RestController
@RequestMapping("doctorManage")
public class DoctorController {
    /**
     * 服务对象
     */
    @Resource
    private DoctorService doctorService;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private HospitalService hospitalService;

    @ApiOperation(value = "获取医生信息", notes = "返回部分user信息")
    @ApiResponses({
//            @ApiResponse(code = 438, message = "用户id or 邮箱 or 密码错误"),
            @ApiResponse(code = 440, message = "无效请求")
    })
    @GetMapping("getDoctorInfo/{id}")
    public Object getDoctorInfo(@PathVariable String id, HttpServletResponse response) {
        Doctor doctor;
        if (id != null && !id.equals("")) {
            doctor = this.doctorService.queryById(id);
        } else {
            response.setStatus(440);
            return null;
        }
        //进行Base64编码
        Department department = departmentService.queryById(doctor.getDepartmentId());
        Hospital hospital = hospitalService.queryById(doctor.getHospitalId());
        Map<String, Object> map = new HashMap<>();
        map.put("doctorId", doctor.getDoctorId());
        map.put("doctorName", doctor.getName());
        map.put("doctorEmail", doctor.getEmail());
        map.put("doctorSex", doctor.getSex());
        map.put("title", doctor.getTitle());
        map.put("hospitalId", doctor.getHospitalId());
        map.put("hisHospital",hospital);
        map.put("departmentId", doctor.getDepartmentId());
        map.put("hisDepartment",department);
        return map;
    }

    @ApiOperation(value = "获取单个医生信息", notes = "返回user信息;pic为base64编码")
    @ApiResponses({
//            @ApiResponse(code = 438, message = "用户id or 邮箱 or 密码错误"),
            @ApiResponse(code = 440, message = "无效请求")
    })
    @GetMapping("getDoctor/{id}")
    public Object getDoctor(@PathVariable String id, HttpServletResponse response) {
        Doctor doctor;
        if (id != null && !id.equals("")) {
            doctor = this.doctorService.queryById(id);
        } else {
            response.setStatus(440);
            return null;
        }
        //进行Base64编码
        String pic=null;
        if(doctor.getPic()!=null){
            BASE64Encoder encoder = new BASE64Encoder();
            pic = encoder.encode(doctor.getPic());
        }
        Department department = departmentService.queryById(doctor.getDepartmentId());
        Hospital hospital = hospitalService.queryById(doctor.getHospitalId());
        Map<String, Object> map = new HashMap<>();
        map.put("doctorId", doctor.getDoctorId());
        map.put("doctorName", doctor.getName());
        map.put("doctorEmail", doctor.getEmail());
        map.put("doctorSex", doctor.getSex());
        map.put("title", doctor.getTitle());
        map.put("hospitalId", doctor.getHospitalId());
        map.put("hisHospital",hospital);
        map.put("departmentId", doctor.getDepartmentId());
        map.put("hisDepartment",department);
        map.put("pic", pic);
        return map;
    }

    @ApiOperation(value = "删除单个医生", notes = "-1、-2失败")
    @ApiResponses({
//            @ApiResponse(code = 438, message = "用户id or 邮箱 or 密码错误"),
            @ApiResponse(code = 440, message = "无效请求")
    })
    @GetMapping("deleteDoctor/{id}")
    public Object deleteDoctorcvc(@PathVariable String id, HttpServletResponse response) {
        if (id != null && !id.equals("")) {
            try {
                this.doctorService.queryById(id);
            } catch (Exception e) {
                return -1;
            }
        } else {
            response.setStatus(440);
            return null;
        }
        boolean b = this.doctorService.deleteById(id);
        if (b)
            return 1;
        else return -2;
    }

    @ApiOperation(value = "获取所有医生信息", notes = "返回user信息;pic为base64编码")
    @ApiResponses({
//            @ApiResponse(code = 438, message = "用户id or 邮箱 or 密码错误"),
            @ApiResponse(code = 440, message = "无效请求")
    })
    @GetMapping("getAllDoctor")
    public Object getAllDoctor(HttpServletResponse response) {
        List<Doctor> doctors = this.doctorService.queryAll();
        List list = new ArrayList();
        for (Doctor doctor : doctors) {
            Map<String, Object> map = new HashMap<>();
            Department department = departmentService.queryById(doctor.getDepartmentId());
            Hospital hospital = hospitalService.queryById(doctor.getHospitalId());
            map.put("doctorId", doctor.getDoctorId());
            map.put("doctorName", doctor.getName());
            map.put("doctorEmail", doctor.getEmail());
            map.put("doctorSex", doctor.getSex());
            map.put("title", doctor.getTitle());
            map.put("hospitalId", doctor.getHospitalId());
            map.put("hisHospital",hospital);
            map.put("departmentId", doctor.getDepartmentId());
            map.put("hisDepartment",department);
            //进行Base64编码
            String pic=null;
            if(doctor.getPic()!=null){
                BASE64Encoder encoder = new BASE64Encoder();
                pic = encoder.encode(doctor.getPic());
            }
            map.put("pic", pic);
            list.add(map);
        }

        return list;
    }

    @ApiOperation(value = "按部门获取医生信息", notes = "")
    @ApiResponses({
//            @ApiResponse(code = 438, message = "用户id or 邮箱 or 密码错误"),
//            @ApiResponse(code = 440, message = "无效请求")
    })
    @GetMapping("getDoctorsByDepartment/{departmentId}")
    public Object getDoctorsByDepartment(@PathVariable Integer departmentId, HttpServletResponse response) {
        List<Department> departments = this.doctorService.queryByDepartmentId(departmentId);
        if (departments != null) return departments;
        else return -1;
    }

    @ApiOperation(value = "按医院获取医生信息", notes = "")
    @ApiResponses({
//            @ApiResponse(code = 438, message = "用户id or 邮箱 or 密码错误"),
//            @ApiResponse(code = 440, message = "无效请求")
    })
    @GetMapping("getDoctorsByHospital/{hospitalId}")
    public Object getDoctorsByHospital(@PathVariable Integer hospitalId, HttpServletResponse response) {
        List<Department> departments = this.doctorService.queryByHospitalId(hospitalId);
        if (departments != null) return departments;
        else return -1;
    }

}
