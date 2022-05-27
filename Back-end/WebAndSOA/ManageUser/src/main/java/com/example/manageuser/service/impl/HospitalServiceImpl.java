package com.example.manageuser.service.impl;

import com.example.manageuser.entity.Hospital;
import com.example.manageuser.dao.HospitalDao;
import com.example.manageuser.service.HospitalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Hospital)表服务实现类
 *
 * @author makejava
 * @since 2022-05-13 19:40:38
 */
@Service("hospitalService")
public class HospitalServiceImpl implements HospitalService {
    @Resource
    private HospitalDao hospitalDao;

    /**
     * 通过ID查询单条数据
     *
     * @param hospitalId 主键
     * @return 实例对象
     */
    @Override
    public Hospital queryById(Integer hospitalId) {
        return this.hospitalDao.queryById(hospitalId);
    }

    @Override
    public List<Hospital> queryAll() {
        return this.hospitalDao.queryAll();
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Hospital> queryAllByLimit(int offset, int limit) {
        return this.hospitalDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param hospital 实例对象
     * @return 实例对象
     */
    @Override
    public Hospital insert(Hospital hospital) {
        this.hospitalDao.insert(hospital);
        return hospital;
    }

    /**
     * 修改数据
     *
     * @param hospital 实例对象
     * @return 实例对象
     */
    @Override
    public Hospital update(Hospital hospital) {
        this.hospitalDao.update(hospital);
        return this.queryById(hospital.getHospitalId());
    }

    /**
     * 通过主键删除数据
     *
     * @param hospitalId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer hospitalId) {
        return this.hospitalDao.deleteById(hospitalId) > 0;
    }
}
