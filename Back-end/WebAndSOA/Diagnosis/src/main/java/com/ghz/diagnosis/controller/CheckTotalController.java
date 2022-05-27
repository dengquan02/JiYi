package com.ghz.diagnosis.controller;

import com.ghz.diagnosis.entity.CheckTotal;
import com.ghz.diagnosis.service.CheckTotalService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CheckTotal)表控制层
 *
 * @author makejava
 * @since 2022-05-14 19:49:21
 */
@RestController
@RequestMapping("checkOption")
public class CheckTotalController {
    /**
     * 服务对象
     */
    @Resource
    private CheckTotalService checkTotalService;


    @ApiOperation(value = "获取检查项目", notes = "")
    @GetMapping("selectCheck")
    public List<CheckTotal> select() {
        return this.checkTotalService.query();
    }


    @ApiOperation(value = "插入检查项目", notes = "")
    @GetMapping("insertCheck/{checkName}")
    public int insertCheck(@PathVariable String checkName) {
        CheckTotal checkTotal=new CheckTotal();
        checkTotal.setCheckName(checkName);
        return this.checkTotalService.insert(checkTotal);
    }

    @ApiOperation(value = "删除检查项目", notes = "")
    @GetMapping("deleteCheck/{checkName}")
    public int deleteCheck(@PathVariable String checkName) {
        boolean b = checkTotalService.deleteById(checkName);
        if(b) return 1;
        else return 0;
    }

}
