package com.example.manageuser.service.impl;

import com.example.manageuser.entity.Department;
import com.example.manageuser.dao.DepartmentDao;
import com.example.manageuser.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Department)表服务实现类
 *
 * @author makejava
 * @since 2022-05-13 19:41:40
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentDao departmentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param departmentId 主键
     * @return 实例对象
     */
    @Override
    public Department queryById(Integer departmentId) {
        return this.departmentDao.queryById(departmentId);
    }

    @Override
    public List<Department> queryAll() {
        return this.departmentDao.queryAll();
    }

    @Override
    public List<Department> queryByHospitalId(int hospitalId) {
        return this.departmentDao.queryByHospitalId(hospitalId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Department> queryAllByLimit(int offset, int limit) {
        return this.departmentDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    @Override
    public Department insert(Department department) {
        this.departmentDao.insert(department);
        return department;
    }

    /**
     * 修改数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    @Override
    public Department update(Department department) {
        this.departmentDao.update(department);
        return this.queryById(department.getDepartmentId());
    }

    /**
     * 通过主键删除数据
     *
     * @param departmentId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer departmentId) {
        return this.departmentDao.deleteById(departmentId) > 0;
    }
}
