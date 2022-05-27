package com.dq.itemmanager.service;

import com.dq.itemmanager.entity.Item;
import java.util.List;

/**
 * (Item)表服务接口
 *
 * @author makejava
 * @since 2022-05-14 20:46:25
 */
public interface ItemService {

    /**
     * 通过ID查询单条数据
     *
     * @param itemId 主键
     * @return 实例对象
     */
    Item queryById(Integer itemId);
    List<Item> queryByHospitalId(Integer hospitalId);
    List<Item> queryByName(String name);
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Item> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param item 实例对象
     * @return 实例对象
     */
    Item insert(Item item);
    List<Item> queryAll();
    /**
     * 修改数据
     *
     * @param item 实例对象
     * @return 实例对象
     */
    Item update(Item item);

    /**
     * 通过主键删除数据
     *
     * @param itemId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer itemId);

}
