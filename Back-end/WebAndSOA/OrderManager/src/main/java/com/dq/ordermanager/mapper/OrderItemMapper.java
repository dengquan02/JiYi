package com.dq.ordermanager.mapper;

import com.dq.ordermanager.pojo.Order;
import com.dq.ordermanager.pojo.OrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


//表示这是一个mybatis的mapper类
@Mapper
@Repository
public interface OrderItemMapper {

    //查(查询指定order下的所有的item)
    List<OrderItem> queryItemsByOrder(String order_id);

    //增
    void generateOrderItem(OrderItem orderItem);

    //改
    int updateOrderItem(OrderItem orderItem);

    //删(删除指定order下的所有的item)
    int deleteItemsByOrder(String order_id);

}
