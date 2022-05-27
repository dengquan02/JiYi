package com.example.manageuser.controller;

import com.example.manageuser.entity.DepartmentTotal;
import com.example.manageuser.service.DepartmentTotalService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (DepartmentTotal)表控制层
 *
 * @author makejava
 * @since 2022-05-14 14:36:48
 */
@RestController
@RequestMapping("departmentAll")
public class DepartmentTotalController {
    /**
     * 服务对象
     */
    @Resource
    private DepartmentTotalService departmentTotalService;

    @ApiOperation(value = "获取部门数据库", notes = "")
    @GetMapping("getAll")
    public List<DepartmentTotal> getAll() {
        return this.departmentTotalService.queryAll();
    }
    @ApiOperation(value = "插入部门数据库", notes = "")
    @GetMapping("insert/{name}")
    public Object insert(@PathVariable String name) {
        DepartmentTotal dt=new DepartmentTotal();
        dt.setDepartmentName(name);
        return this.departmentTotalService.insert(dt);
    }
    @ApiOperation(value = "删除部门数据库", notes = "")
    @GetMapping("delete/{name}")
    public Object delete(@PathVariable String name) {
        return this.departmentTotalService.delete(name);
    }

}
