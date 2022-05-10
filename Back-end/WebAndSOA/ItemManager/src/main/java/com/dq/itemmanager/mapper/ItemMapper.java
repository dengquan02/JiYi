package com.dq.itemmanager.mapper;

import com.dq.itemmanager.pojo.Item;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//表示这是一个mybatis的mapper类
@Mapper
@Repository
public interface ItemMapper {

    //查
    List<Item> queryItemList();

    Item queryItemById(String id);

    Item queryItemByName(String name);

    //增
    int addItem(Item item);

    //改
    int updateItem(Item item);

    //修改num（eg:库存减少）
    int changeItemNum(String item_id, int change);

    //删
    int deleteItem(String id);

}
