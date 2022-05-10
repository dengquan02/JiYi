package com.dq.ordermanager.controller;

import com.dq.ordermanager.feign.ItemFeignService;
import com.dq.ordermanager.mapper.OrderItemMapper;
import com.dq.ordermanager.mapper.OrderMapper;
import com.dq.ordermanager.pojo.Item;
import com.dq.ordermanager.pojo.Order;
import com.dq.ordermanager.pojo.OrderItem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@Api(tags = "订单服务")
@RequestMapping("/api/v1/OrderManager")
public class OrderController {

    @Autowired
    ItemFeignService itemFeignService;
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private OrderMapper orderMapper;

    @ApiOperation("查找订单请求")
    @GetMapping("/queryOrderList")
    public List<Order> queryOrderList() {
        List<Order> orders = orderMapper.queryOrderList();
        System.out.println("查找订单列表成功！");
        for (Order order : orders) {
            System.out.println(order);
        }
        return orders;
    }

    @ApiOperation("查找特定订单")
    @GetMapping("/queryOrderById/{order_id}")
    public Order queryOrderById(
            @PathVariable("order_id") String order_id
    ) {
        Order order = orderMapper.queryOrderById(order_id);
        if (order == null) {
            System.out.println("订单" + order_id + "不存在！");
            return null;
        }
        System.out.println("查找订单" + order_id + "成功！");
        System.out.println(order);
        return order;
    }

    @ApiOperation("根据病人查找订单")
    @GetMapping("/queryOrderByPatient/{patient_id}")
    public List<Order> queryOrderByPatient(
            @PathVariable("patient_id") String patient_id
    ) {
        List<Order> orders = orderMapper.queryOrderByPatient(patient_id);
        System.out.println("查询病人" + patient_id + "的订单记录！");
        for (Order order : orders) {
            System.out.println(order);
        }
        return orders;
    }

    @GetMapping("/testFeign")
    public String test() {
        System.out.println("for test");
        String id = "163999209474060";
        String msg = itemFeignService.queryItemById(id).getItem_id();
        return "Hello Feign " + msg;
    }

    @ApiOperation("增加订单")
    @GetMapping("/generateOrder")
    public int generateOrder (
            String patient_id,
            String[] itemsId,
            int[] itemsNum
    ) {
        //id生成
        //取当前时间的长整形值包含毫秒
        long millis = System.currentTimeMillis();
        //long millis = System.nanoTime();
        //加上两位随机数
        Random random = new Random();
        int end2 = random.nextInt(99);
        //如果不足两位前面补0
        String order_id = millis + String.format("%02d", end2);

        //date生成
        // 初始化 Date 对象 dNow
        Date dNow = new Date();
        // 显示日期时间
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        System.out.println(ft.format(dNow));
        String date = ft.format(dNow);
        Order order = new Order(order_id, date, patient_id);
        System.out.println(order);

        System.out.println("----itemsId----");
        for (String s:itemsId) {
            System.out.println(s);
        }
        System.out.println("----itemsNum----");
        for (int i:itemsNum) {
            System.out.println(i);
        }
        //错误处理
        if (itemsId.length != itemsNum.length) {
            System.out.println("参数ERROR!");
            return 0;
        }

        //添加order本身
        orderMapper.generateOrder(order);
        //添加order下所有的item
        for (int i = 0; i < itemsId.length; i++) {
            String item_id = itemsId[i];
            int num = itemsNum[i];
            OrderItem orderItem = new OrderItem(order_id,item_id,num);
            orderItemMapper.generateOrderItem(orderItem);
            //库存减少
            Item item = itemFeignService.queryItemById(item_id);
            System.out.println("库存减少前: ");
//            System.out.println(item.getItem_id() + ", " + item.getPrice() + ", " + item.getNum() + ", " + item.getName());
            itemFeignService.changeItemNum(item_id, -num);
            item = itemFeignService.queryItemById(item_id);
            System.out.println("库存减少后: ");
//            System.out.println(item);
        }
        System.out.println("生成订单" + order_id + "！");

        System.out.println(order);
        return 1;
    }


    @ApiOperation("删除订单")
    @GetMapping("deleteOrder/{order_id}")
    public int deleteOrder(
            @PathVariable("order_id") String order_id
    ) {
        Order order = queryOrderById(order_id);
        if (order == null) {
//            System.out.println("不存在订单" + item_id + "！");
            return 0;
        }
        //删除指定order本身
        orderMapper.deleteOrder(order_id);
        //删除指定order下的所有的item
        orderItemMapper.deleteItemsByOrder(order_id);
        System.out.println("订单" + order_id + "已删除！");
        System.out.println(order);
        return 1;
    }

}
