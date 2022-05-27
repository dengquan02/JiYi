package com.ghz.diagnosis.controller;

import com.ghz.diagnosis.entity.DiseaseTotal;
import com.ghz.diagnosis.entity.DiseaseTotal;
import com.ghz.diagnosis.service.DiseaseTotalService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (DiseaseTotal)表控制层
 *
 * @author makejava
 * @since 2022-05-14 19:51:28
 */
@RestController
@RequestMapping("diseaseOption")
public class DiseaseTotalController {
    /**
     * 服务对象
     */
    @Resource
    private DiseaseTotalService diseaseTotalService;

    @ApiOperation(value = "获取疾病列表", notes = "")
    @GetMapping("selectDisease")
    public List<DiseaseTotal> select() {
        return this.diseaseTotalService.query();
    }


    @ApiOperation(value = "插入疾病列表", notes = "")
    @GetMapping("insertDisease/{diseaseName}")
    public int insertDisease(@PathVariable String diseaseName) {
        DiseaseTotal diseaseTotal=new DiseaseTotal();
        diseaseTotal.setDiseaseName(diseaseName);
        return this.diseaseTotalService.insert(diseaseTotal);
    }

    @ApiOperation(value = "删除疾病列表", notes = "")
    @GetMapping("deleteDisease/{diseaseName}")
    public int deleteDisease(@PathVariable String diseaseName) {
        boolean b = diseaseTotalService.deleteById(diseaseName);
        if(b) return 1;
        else return 0;
    }

}
