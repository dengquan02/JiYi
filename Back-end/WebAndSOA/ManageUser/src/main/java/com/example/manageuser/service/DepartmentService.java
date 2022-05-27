package com.example.manageuser.service;

import com.example.manageuser.entity.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Department)表服务接口
 *
 * @author makejava
 * @since 2022-05-13 19:41:40
 */
public interface DepartmentService {

    /**
     * 通过ID查询单条数据
     *
     * @param departmentId 主键
     * @return 实例对象
     */
    Department queryById(Integer departmentId);
    List<Department> queryAll();
    List<Department> queryByHospitalId(int hospitalId);
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Department> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    Department insert(Department department);

    /**
     * 修改数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    Department update(Department department);

    /**
     * 通过主键删除数据
     *
     * @param departmentId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer departmentId);

}
