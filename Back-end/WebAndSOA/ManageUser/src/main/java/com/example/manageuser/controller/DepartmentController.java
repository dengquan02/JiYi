package com.example.manageuser.controller;

import com.example.manageuser.entity.Department;
import com.example.manageuser.entity.Department;
import com.example.manageuser.entity.Hospital;
import com.example.manageuser.service.DepartmentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * (Department)表控制层
 *
 * @author makejava
 * @since 2022-05-13 19:41:40
 */
@RestController
@RequestMapping("departmentManage")
public class DepartmentController {
    /**
     * 服务对象
     */
    @Resource
    private DepartmentService departmentService;


    @ApiOperation(value = "获取单个部门信息", notes = "")
    @ApiResponses({
//            @ApiResponse(code = 438, message = "用户id or 邮箱 or 密码错误"),
//            @ApiResponse(code = 440, message = "无效请求")
    })
    @GetMapping("getDepartment/{id}")
    public Object getDepartment(@PathVariable Integer id, HttpServletResponse response) {
        Department department = this.departmentService.queryById(id);
        if(department!=null) return department;
        else return -1;
    }

    @ApiOperation(value = "获取所有部门信息", notes = "")
    @ApiResponses({
//            @ApiResponse(code = 438, message = "用户id or 邮箱 or 密码错误"),
//            @ApiResponse(code = 440, message = "无效请求")
    })
    @GetMapping("getAllDepartment")
    public Object getAllDepartment(HttpServletResponse response) {
        List<Department> departments = this.departmentService.queryAll();
        if(departments!=null) return departments;
        else return -1;
    }

    @ApiOperation(value = "按医院获取部门信息", notes = "")
    @ApiResponses({
//            @ApiResponse(code = 438, message = "用户id or 邮箱 or 密码错误"),
//            @ApiResponse(code = 440, message = "无效请求")
    })
    @GetMapping("getDepartmentByHospital/{hospitalId}")
    public Object getAllDepartment(@PathVariable Integer hospitalId, HttpServletResponse response) {
        List<Department> departments = this.departmentService.queryByHospitalId(hospitalId);
        if(departments!=null) return departments;
        else return -1;
    }


    @ApiOperation(value = "删除某个部门", notes = "-1、-2失败")
    @ApiResponses({
//            @ApiResponse(code = 438, message = "用户id or 邮箱 or 密码错误"),
//            @ApiResponse(code = 440, message = "无效请求")
    })
    @GetMapping("deleteDepartment/{id}")
    public Object deleteDepartment(@PathVariable Integer id, HttpServletResponse response) {
        if (id != null) {
            try {
                this.departmentService.queryById(id);
            } catch (Exception e) {
                return -1;
            }
        } else {
            response.setStatus(440);
            return null;
        }
        boolean b = this.departmentService.deleteById(id);
        if (b)
            return 1;
        else return -2;
    }

    @ApiOperation(value = "新增部门", notes = "")
    @ApiResponses({
//            @ApiResponse(code = 438, message = "用户id or 邮箱 or 密码错误"),
//            @ApiResponse(code = 440, message = "无效请求")
    })
    @PostMapping("addDepartment")
    public Object addDepartment(@RequestParam Integer id,
                              @RequestParam String name,
                              @RequestParam Integer hospitalId,
                              String type,
                              HttpServletResponse response) {
       Department department=new Department(id,name,hospitalId,type);
        return departmentService.insert(department);
    }

    @ApiOperation(value = "修改部门", notes = "")
    @ApiResponses({
//            @ApiResponse(code = 438, message = "用户id or 邮箱 or 密码错误"),
//            @ApiResponse(code = 440, message = "无效请求")
    })
    @PostMapping("modifyHospital")
    public Object modifyHospital(@RequestParam Integer id,
                                 String name,
                                 String type,
                                 HttpServletResponse response) {
      Department department=departmentService.queryById(id);
        if(name!=null&&!name.equals("")){
            department.setName(name);
        }
        if(type!=null&&!type.equals("")){
            department.setType(type);
        }
        return departmentService.update(department);
    }
}
