package com.example.signup.service.impl;

import com.example.signup.entity.Patient;
import com.example.signup.dao.PatientDao;
import com.example.signup.service.PatientService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Patient)表服务实现类
 *
 * @author makejava
 * @since 2022-05-13 07:09:25
 */
@Service("patientService")
public class PatientServiceImpl implements PatientService {
    @Resource
    private PatientDao patientDao;

    /**
     * 通过ID查询单条数据
     *
     * @param patientId 主键
     * @return 实例对象
     */
    @Override
    public Patient queryById(String patientId) {
        return this.patientDao.queryById(patientId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Patient> queryAllByLimit(int offset, int limit) {
        return this.patientDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param patient 实例对象
     * @return 实例对象
     */
    @Override
    public Patient insert(Patient patient) {
        this.patientDao.insert(patient);
        return patient;
    }

    /**
     * 修改数据
     *
     * @param patient 实例对象
     * @return 实例对象
     */
    @Override
    public Patient update(Patient patient) {
        this.patientDao.update(patient);
        return this.queryById(patient.getPatientId());
    }

    /**
     * 通过主键删除数据
     *
     * @param patientId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String patientId) {
        return this.patientDao.deleteById(patientId) > 0;
    }

    @Override
    public Patient queryByEmail(String email) {
        return this.patientDao.queryByEmail(email);
    }
}
