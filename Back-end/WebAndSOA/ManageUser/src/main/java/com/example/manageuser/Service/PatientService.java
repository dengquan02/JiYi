package com.example.manageuser.service;

import com.example.manageuser.entity.Patient;
import java.util.List;

/**
 * (Patient)表服务接口
 *
 * @author makejava
 * @since 2022-05-13 19:36:33
 */
public interface PatientService {

    /**
     * 通过ID查询单条数据
     *
     * @param patientId 主键
     * @return 实例对象
     */
    Patient queryById(String patientId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Patient> queryAllByLimit(int offset, int limit);
    List<Patient> queryAll();
    /**
     * 新增数据
     *
     * @param patient 实例对象
     * @return 实例对象
     */
    Patient insert(Patient patient);

    /**
     * 修改数据
     *
     * @param patient 实例对象
     * @return 实例对象
     */
    Patient update(Patient patient);

    /**
     * 通过主键删除数据
     *
     * @param patientId 主键
     * @return 是否成功
     */
    boolean deleteById(String patientId);

}
