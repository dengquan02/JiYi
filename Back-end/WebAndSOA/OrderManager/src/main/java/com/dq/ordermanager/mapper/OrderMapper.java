package com.dq.ordermanager.mapper;

import com.dq.ordermanager.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//表示这是一个mybatis的mapper类
@Mapper
@Repository
public interface OrderMapper {
    //查
    List<Order> queryOrderList();

    Order queryOrderById(String id);

    List<Order> queryOrderByPatient(String patient_id);

    //增
    int generateOrder(Order order);

    //改
    int updateOrder(Order order);

    //删
    int deleteOrder(String id);
}
