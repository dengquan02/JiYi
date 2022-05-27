package com.dq.itemmanager.controller;

import com.dq.itemmanager.entity.Item;
import com.dq.itemmanager.service.ItemService;
import com.dq.itemmanager.service.QiniuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * (Item)表控制层
 *
 * @author makejava
 * @since 2022-05-14 20:46:26
 */
@RestController
@RequestMapping("item")
public class ItemController {
    /**
     * 服务对象
     */
    @Resource
    private ItemService itemService;
    @Autowired
    private QiniuService qiniuService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
//    @GetMapping("selectOne")
//    public Item selectOne(String id) {
//        return this.itemService.queryById(id);
//    }
    @ApiOperation(value = "id选择药品", notes = "")
    @PostMapping("/queryById")
    public Object queryById(@RequestParam Integer id,
                            HttpServletResponse response) {
        return itemService.queryById(id);
    }

    @ApiOperation(value = "获取所有药品", notes = "")
    @PostMapping("/queryAll")
    public Object queryAll(@RequestParam Integer id,
                           HttpServletResponse response) {
        return itemService.queryById(id);
    }

    @ApiOperation(value = "按名称获取药品", notes = "")
    @PostMapping("/queryByName")
    public Object queryByName(@RequestParam String name,
                              HttpServletResponse response) {
        return itemService.queryByName(name);
    }

    @ApiOperation(value = "按医院获取药品", notes = "")
    @PostMapping("/queryByHospitalId")
    public Object queryByHospitalId(@RequestParam Integer hId,
                                    HttpServletResponse response) {
        return itemService.queryByHospitalId(hId);
    }

    @ApiOperation(value = "更新药品", notes = "")
    @PostMapping("/modifyDrug")
    public Object modifyDrug(@RequestParam Integer id,
                             Double price,
                             Integer num,
                             String name,
                             @RequestParam Integer hId,
                             Integer otc,
                             MultipartFile file,
                             HttpServletResponse response) throws Exception {

        Item i = itemService.queryById(id);
        if (price != null) {
            i.setPrice(price);
        }
        if (num != null) {
            i.setNum(num);
        }
        if (name != null && !name.equals("")) {
            i.setName(name);
        }
        if (otc != null) {
            if (otc > 0) otc = 1;
            else otc = 0;
            i.setOtc(otc);
        }
        String url = null;
        if (file != null) {
            url = qiniuService.uploadFile(file.getInputStream());
            i.setImg(url);
        }
        return itemService.update(i);
    }

    @ApiOperation(value = "新增药品", notes = "otc-处方药1，非处方药0")
    @PostMapping("/newDrug")
    public Object newDrug(@RequestParam Integer id,
                          @RequestParam Double price,
                          @RequestParam Integer num,
                          @RequestParam String name,
                          @RequestParam Integer hId,
                          @RequestParam Integer otc,
                          @RequestParam MultipartFile file,
                          HttpServletResponse response) throws Exception {
        if (otc > 0) otc = 1;
        else otc = 0;
        String url = qiniuService.uploadFile(file.getInputStream());
        Item item = new Item(id, price, num, name, hId, otc, url);
        return itemService.insert(item);
    }

    @ApiOperation(value = "删除药品", notes = "")
    @PostMapping("/deleteDrug")
    public Object newDrug(@RequestParam Integer id,
                          HttpServletResponse response) throws Exception{
        qiniuService.delete(itemService.queryById(id).getImg());
        return itemService.deleteById(id);
    }
}
