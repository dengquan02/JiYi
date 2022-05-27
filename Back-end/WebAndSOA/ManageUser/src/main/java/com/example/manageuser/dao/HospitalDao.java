package com.example.manageuser.dao;

import com.example.manageuser.entity.Hospital;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Hospital)表数据库访问层
 *
 * @author makejava
 * @since 2022-05-13 19:40:38
 */
public interface HospitalDao {

    /**
     * 通过ID查询单条数据
     *
     * @param hospitalId 主键
     * @return 实例对象
     */
    Hospital queryById(Integer hospitalId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Hospital> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    List<Hospital> queryAll();

    /**
     * 新增数据
     *
     * @param hospital 实例对象
     * @return 影响行数
     */
    int insert(Hospital hospital);

    /**
     * 修改数据
     *
     * @param hospital 实例对象
     * @return 影响行数
     */
    int update(Hospital hospital);

    /**
     * 通过主键删除数据
     *
     * @param hospitalId 主键
     * @return 影响行数
     */
    int deleteById(Integer hospitalId);

}
