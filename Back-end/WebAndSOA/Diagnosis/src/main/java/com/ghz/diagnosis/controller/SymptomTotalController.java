package com.ghz.diagnosis.controller;

import com.ghz.diagnosis.entity.SymptomTotal;
import com.ghz.diagnosis.entity.SymptomTotal;
import com.ghz.diagnosis.service.SymptomTotalService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SymptomTotal)表控制层
 *
 * @author makejava
 * @since 2022-05-14 19:52:14
 */
@RestController
@RequestMapping("symptomTotal")
public class SymptomTotalController {
    /**
     * 服务对象
     */
    @Resource
    private SymptomTotalService symptomTotalService;
    @ApiOperation(value = "获取症状列表", notes = "")
    @GetMapping("selectSymptom")
    public List<SymptomTotal> select() {
        return this.symptomTotalService.query();
    }


    @ApiOperation(value = "插入症状列表", notes = "")
    @GetMapping("insertSymptom/{symptomName}")
    public int insertSymptom(@PathVariable String symptomName) {
        SymptomTotal symptomTotal=new SymptomTotal();
        symptomTotal.setSymptomName(symptomName);
        return this.symptomTotalService.insert(symptomTotal);
    }

    @ApiOperation(value = "删除症状列表", notes = "")
    @GetMapping("deleteSymptom/{symptomName}")
    public int deleteSymptom(@PathVariable String symptomName) {
        boolean b = symptomTotalService.deleteById(symptomName);
        if(b) return 1;
        else return 0;
    }

}
