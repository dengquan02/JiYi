package com.example.signup.service.impl;

import com.example.signup.entity.Doctor;
import com.example.signup.dao.DoctorDao;
import com.example.signup.service.DoctorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Doctor)表服务实现类
 *
 * @author makejava
 * @since 2022-05-13 17:57:08
 */
@Service("doctorService")
public class DoctorServiceImpl implements DoctorService {
    @Resource
    private DoctorDao doctorDao;

    /**
     * 通过ID查询单条数据
     *
     * @param doctorId 主键
     * @return 实例对象
     */
    @Override
    public Doctor queryById(String doctorId) {
        return this.doctorDao.queryById(doctorId);
    }

    @Override
    public Doctor queryByEmail(String email) {
        return this.doctorDao.queryByEmail(email);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Doctor> queryAllByLimit(int offset, int limit) {
        return this.doctorDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param doctor 实例对象
     * @return 实例对象
     */
    @Override
    public Doctor insert(Doctor doctor) {
        this.doctorDao.insert(doctor);
        return doctor;
    }

    /**
     * 修改数据
     *
     * @param doctor 实例对象
     * @return 实例对象
     */
    @Override
    public Doctor update(Doctor doctor) {
        this.doctorDao.update(doctor);
        return this.queryById(doctor.getDoctorId());
    }

    /**
     * 通过主键删除数据
     *
     * @param doctorId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String doctorId) {
        return this.doctorDao.deleteById(doctorId) > 0;
    }
}
