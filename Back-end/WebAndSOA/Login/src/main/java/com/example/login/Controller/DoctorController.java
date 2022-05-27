package com.example.login.controller;

import com.example.login.config.TokenUtil;
import com.example.login.entity.Doctor;
import com.example.login.entity.Patient;
import com.example.login.service.DoctorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * (Doctor)表控制层
 *
 * @author makejava
 * @since 2022-05-12 00:03:58
 */
@RestController
@RequestMapping("doctor")
public class DoctorController {
    /**
     * 服务对象
     */
    @Resource
    private DoctorService doctorService;
    private String token;
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "登录接口", notes = "二选一传入邮箱、用户id，返回user信息和token")
    @ApiResponses({
            @ApiResponse(code = 438, message = "用户id or 邮箱 or 密码错误"),
            @ApiResponse(code = 440, message = "无效请求")
    })
    @PostMapping("/login")
    public List selectOne(String id, String email,
                          @RequestParam String passwd,
                          HttpServletResponse response, HttpServletRequest request) {
        Doctor patient;
        if (id != null&& !id.equals("")) {
            patient = this.doctorService.queryById(id);
        } else if (email != null && !email.equals("")) {
            patient = this.doctorService.queryByEmail(email);
        } else {
            response.setStatus(440);
            return null;
        }
        if (patient == null || !patient.getPassword().equals(passwd)) {
            response.setStatus(438);
            return null;
        }
        token = TokenUtil.sign(patient.getDoctorId());
        TokenUtil.verify(token);
        HttpSession session = request.getSession();
        session.setAttribute("token", token);
//        session.setAttribute("你好", "这是session");
        session.setMaxInactiveInterval(60 * 60 * 24);
        String pic=null;
        if(patient.getPic()!=null){
            BASE64Encoder encoder = new BASE64Encoder();
            pic = encoder.encode(patient.getPic());
        }

        List list=new ArrayList();
        list.add(patient.getDoctorId());
        list.add(patient.getName());
        list.add(patient.getEmail());
        list.add(patient.getSex());
        list.add(pic);
        list.add(token);
        Object token = session.getAttribute("token");
        System.out.println(token);
        return list;
    }

}
