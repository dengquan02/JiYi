package com.example.login.controller;

import com.example.login.entity.Admin;
import com.example.login.service.AdminService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * (Admin)表控制层
 *
 * @author makejava
 * @since 2022-05-12 07:58:12
 */
@RestController
@RequestMapping("admin")
public class AdminController {
    /**
     * 服务对象
     */
    @Resource
    private AdminService adminService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @PostMapping("/login")
    public Admin selectOne(@RequestParam Integer id, @RequestParam String passwd,
                           HttpServletResponse response, HttpServletRequest request) {
        Admin admin;
        if (id != null) {
            admin = this.adminService.queryById(id);
        } else {
            response.setStatus(440);
            return null;
        }
        if (admin == null || !admin.getPassword().equals(passwd)) {
            response.setStatus(438);
            return null;
        }
        return admin;
    }

}
