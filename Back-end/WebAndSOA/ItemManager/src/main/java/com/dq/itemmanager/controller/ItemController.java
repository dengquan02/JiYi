package com.dq.itemmanager.controller;

import com.dq.itemmanager.mapper.ItemMapper;
import com.dq.itemmanager.pojo.Item;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;


@RestController
@Api(tags = "商品服务")
@RequestMapping("/api/v1/ItemManager")
public class ItemController {

    @Autowired
    private ItemMapper itemMapper;

    @ApiOperation("查找商品列表")
    @GetMapping("/queryItemList")
    public List<Item> queryItemList() {
        List<Item> items = itemMapper.queryItemList();
        System.out.println("查找药物列表成功！");
        for (Item item : items) {
            System.out.println(item);
        }
        return items;
    }

    @ApiOperation("查找单个商品")
    @GetMapping("/queryItemById/{item_id}")
    public Item queryItemById(
            @PathVariable("item_id") String item_id
    ) {
        Item item = itemMapper.queryItemById(item_id);
        if (item == null) {
            System.out.println("药物" + item_id + "不存在！");
            return null;
        }
        System.out.println("药物" + item_id + "已找到！");
        System.out.println(item);
        return item;
    }

    @ApiOperation("查找单个商品")
    @GetMapping("/queryItemByName/{name}")
    public Item queryItemByName(
            @PathVariable("name") String name
    ) {
        Item item = itemMapper.queryItemByName(name);
        if (item == null) {
            System.out.println("药物" + name + "不存在！");
            return null;
        }
        System.out.println("药物" + name + "已找到！");
        System.out.println(item);
        return item;
    }

    @ApiOperation("添加药品")
    @GetMapping("/addItem/{name}/{price}/{num}")
    public int addItem(
            @PathVariable("price") double price,
            @PathVariable("num") int num,
            @PathVariable("name") String name
    ) {
        //id生成
        //取当前时间的长整形值包含毫秒
        long millis = System.currentTimeMillis();
        //long millis = System.nanoTime();
        //加上两位随机数
        Random random = new Random();
        int end2 = random.nextInt(99);
        //如果不足两位前面补0
        String item_id = millis + String.format("%02d", end2);

        Item item = new Item(item_id, price, num, name);
        itemMapper.addItem(item);
        System.out.println("添加药物" + item_id + "成功！");
        System.out.println(item);
        return 1;
    }

    @ApiOperation("更新药品")
    @GetMapping("updateItem/{item_id}/{name}/{price}/{num}")
    public int updateItem(
            @PathVariable("item_id") String item_id,
            @PathVariable("price") double price,
            @PathVariable("num") int num,
            @PathVariable("name") String name
    ) {
        if (queryItemById(item_id) == null) {
//            System.out.println("不存在药物" + item_id + "！");
            return 0;
        }
        Item item = new Item(item_id, price, num, name);
        itemMapper.updateItem(item);
        System.out.println("药物" + item_id + "已更新！");
        System.out.println(item);
        return 1;
    }

    //更新药品库存
    @ApiOperation("更新药品")
    @GetMapping("updateItem/{item_id}/{change}")
    public int changeItemNum(
            @PathVariable("item_id") String item_id,
            @PathVariable("change") int change
    ) {
        Item item = queryItemById(item_id);
        if (item == null) {
//            System.out.println("不存在药物" + item_id + "！");
            return 0;
        }
        System.out.println("药物" + item_id + "库存更新前:");
        System.out.println(item);
//        itemMapper.changeItemNum(item_id, change);
        item.setNum(item.getNum() + change);
        itemMapper.updateItem(item);

        System.out.println("药物" + item_id + "库存已更新！");
        item = queryItemById(item_id);
        System.out.println(item);
        return 1;
    }

    @ApiOperation("删除药品")
    @GetMapping("deleteItem/{item_id}")
    public int deleteItem(
            @PathVariable("item_id") String item_id
    ) {
        Item item = queryItemById(item_id);
        if (item == null) {
//            System.out.println("不存在药物" + item_id + "！");
            return 0;
        }
        itemMapper.deleteItem(item_id);
        System.out.println("药物" + item_id + "已删除！");
        System.out.println(item);
        return 1;
    }

}
