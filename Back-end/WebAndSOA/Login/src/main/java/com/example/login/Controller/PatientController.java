package com.example.login.controller;

import com.example.login.config.TokenUtil;
import com.example.login.entity.Patient;
import com.example.login.service.PatientService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.codec.binary.Base64;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * (Patient)表控制层
 *
 * @author makejava
 * @since 2022-05-12 07:57:44
 */
@RestController
@RequestMapping("patient")
public class PatientController {
    /**
     * 服务对象
     */
    @Resource
    private PatientService patientService;
    private String token;
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "登录接口", notes = "二选一传入邮箱、用户id，返回user信息和token;pic为base64编码")
    @ApiResponses({
            @ApiResponse(code = 438, message = "用户id or 邮箱 or 密码错误"),
            @ApiResponse(code = 440, message = "无效请求")
    })
    @PostMapping("/login")
    public List selectOne(String id, String email,
                             @RequestParam String passwd,
                             HttpServletResponse response, HttpServletRequest request) {
        Patient patient;
        if (id != null&& !id.equals("")) {
            patient = this.patientService.queryById(id);
        } else if (email != null && !email.equals("")) {
            patient = this.patientService.queryByEmail(email);
        } else {
            response.setStatus(440);
            return null;
        }
        if (patient == null || !patient.getPassword().equals(passwd)) {
            response.setStatus(438);
            return null;
        }
        token = TokenUtil.sign(patient.getPatientId());
        TokenUtil.verify(token);
        HttpSession session = request.getSession();
        session.setAttribute("token", token);
        session.setAttribute("user", patient.getPatientId());
//        session.setAttribute("你好", "这是session");
        session.setMaxInactiveInterval(60 * 60 * 24);
        //进行Base64编码
        String pic=null;
        if(patient.getPic()!=null){
            BASE64Encoder encoder = new BASE64Encoder();
            pic = encoder.encode(patient.getPic());
        }

        List list=new ArrayList();
        list.add(patient.getPatientId());
        list.add(patient.getName());
        list.add(patient.getEmail());
        list.add(patient.getSex());
        list.add(patient.getAge());
        list.add(pic);
        list.add(token);
        Object token = session.getAttribute("token");
        System.out.println(token);
        return list;
    }

}
