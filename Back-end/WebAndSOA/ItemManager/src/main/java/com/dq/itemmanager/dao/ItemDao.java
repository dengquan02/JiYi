package com.dq.itemmanager.dao;

import com.dq.itemmanager.entity.Item;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Item)表数据库访问层
 *
 * @author makejava
 * @since 2022-05-14 20:46:25
 */
public interface ItemDao {

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
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Item> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    List<Item> queryAll();

    /**
     * 新增数据
     *
     * @param item 实例对象
     * @return 影响行数
     */
    int insert(Item item);

    /**
     * 修改数据
     *
     * @param item 实例对象
     * @return 影响行数
     */
    int update(Item item);

    /**
     * 通过主键删除数据
     *
     * @param itemId 主键
     * @return 影响行数
     */
    int deleteById(Integer itemId);

}
