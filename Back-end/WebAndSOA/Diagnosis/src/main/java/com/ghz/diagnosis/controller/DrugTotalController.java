package com.ghz.diagnosis.controller;

import com.ghz.diagnosis.entity.DrugTotal;
import com.ghz.diagnosis.entity.DrugTotal;
import com.ghz.diagnosis.service.DrugTotalService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (DrugTotal)表控制层
 *
 * @author makejava
 * @since 2022-05-14 19:51:51
 */
@RestController
@RequestMapping("drugOption")
public class DrugTotalController {
    /**
     * 服务对象
     */
    @Resource
    private DrugTotalService drugTotalService;
    @ApiOperation(value = "获取药品列表", notes = "")
    @GetMapping("selectDrug")
    public List<DrugTotal> select() {
        return this.drugTotalService.query();
    }


    @ApiOperation(value = "插入药品列表", notes = "")
    @GetMapping("insertDrug/{drugName}")
    public int insertDrug(@PathVariable String drugName) {
        DrugTotal drugTotal=new DrugTotal();
        drugTotal.setDrugName(drugName);
        return this.drugTotalService.insert(drugTotal);
    }

    @ApiOperation(value = "删除药品列表", notes = "")
    @GetMapping("deleteDrug/{drugName}")
    public int deleteDrug(@PathVariable String drugName) {
        boolean b = drugTotalService.deleteById(drugName);
        if(b) return 1;
        else return 0;
    }

}
