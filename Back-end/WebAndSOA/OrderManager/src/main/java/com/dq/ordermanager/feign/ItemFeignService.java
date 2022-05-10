package com.dq.ordermanager.feign;

import com.dq.ordermanager.pojo.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "item-service", path = "/api/v1/ItemManager")
public interface ItemFeignService {

    @GetMapping("updateItem/{item_id}/{change}")
    int changeItemNum(
            @PathVariable("item_id") String item_id,
            @PathVariable("change") int change
    );

    @GetMapping("/queryItemList")
    List<Item> queryItemList();

    @GetMapping("/queryItemById/{item_id}")
    Item queryItemById(
            @PathVariable("item_id") String item_id
    );

    //增
    @GetMapping("/addItem/{name}/{price}/{num}")
    int addItem(
            @PathVariable("price") double price,
            @PathVariable("num") int num,
            @PathVariable("name") String name
    );


    //删
    @GetMapping("deleteItem/{item_id}")
    int deleteItem(
            @PathVariable("item_id") String item_id
    );

}

/*

@RestController
public class ItemController {

    @Autowired
    private ItemMapper itemMapper;

    //查
    @GetMapping("/queryItemList")
    public List<Item> queryItemList() {
        List<Item> items = itemMapper.queryItemList();
        System.out.println("查找药物列表成功！");
        for (Item item : items) {
            System.out.println(item);
        }
        return items;
    }

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

    //增
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

    //改
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

    //删
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

 */