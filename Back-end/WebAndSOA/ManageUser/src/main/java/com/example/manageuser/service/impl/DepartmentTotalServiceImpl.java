package com.example.manageuser.service.impl;

import com.example.manageuser.entity.DepartmentTotal;
import com.example.manageuser.dao.DepartmentTotalDao;
import com.example.manageuser.service.DepartmentTotalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (DepartmentTotal)表服务实现类
 *
 * @author makejava
 * @since 2022-05-14 14:36:48
 */
@Service("departmentTotalService")
public class DepartmentTotalServiceImpl implements DepartmentTotalService {
    @Resource
    private DepartmentTotalDao departmentTotalDao;

    @Override
    public List<DepartmentTotal> queryAll() {
        return this.departmentTotalDao.queryAll();
    }

    @Override
    public int insert(DepartmentTotal departmentTotal) {
        return this.departmentTotalDao.insert(departmentTotal);
    }

    @Override
    public int delete(String departmentName) {
        return this.departmentTotalDao.delete(departmentName);
    }
}
