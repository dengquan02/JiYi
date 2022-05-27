package com.dq.itemmanager.service.impl;

import com.dq.itemmanager.entity.Item;
import com.dq.itemmanager.dao.ItemDao;
import com.dq.itemmanager.service.ItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Item)表服务实现类
 *
 * @author makejava
 * @since 2022-05-14 20:46:25
 */
@Service("itemService")
public class ItemServiceImpl implements ItemService {
    @Resource
    private ItemDao itemDao;

    /**
     * 通过ID查询单条数据
     *
     * @param itemId 主键
     * @return 实例对象
     */
    @Override
    public Item queryById(Integer itemId) {
        return this.itemDao.queryById(itemId);
    }

    @Override
    public List<Item> queryByHospitalId(Integer hospitalId) {
        return this.itemDao.queryByHospitalId(hospitalId);
    }

    @Override
    public List<Item> queryByName(String name) {
        return this.itemDao.queryByName(name);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Item> queryAllByLimit(int offset, int limit) {
        return this.itemDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param item 实例对象
     * @return 实例对象
     */
    @Override
    public Item insert(Item item) {
        this.itemDao.insert(item);
        return item;
    }

    @Override
    public List<Item> queryAll() {
        return this.itemDao.queryAll();
    }

    /**
     * 修改数据
     *
     * @param item 实例对象
     * @return 实例对象
     */
    @Override
    public Item update(Item item) {
        this.itemDao.update(item);
        return this.itemDao.queryById(item.getItemId());
    }

    /**
     * 通过主键删除数据
     *
     * @param itemId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer itemId) {
        return this.itemDao.deleteById(itemId) > 0;
    }
}
