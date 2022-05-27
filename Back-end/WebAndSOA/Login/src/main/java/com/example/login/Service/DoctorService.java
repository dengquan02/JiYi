package com.example.login.service;

import com.example.login.entity.Doctor;
import java.util.List;

/**
 * (Doctor)表服务接口
 *
 * @author makejava
 * @since 2022-05-12 00:03:57
 */
public interface DoctorService {

    /**
     * 通过ID查询单条数据
     *
     * @param doctorId 主键
     * @return 实例对象
     */
    Doctor queryById(String doctorId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Doctor> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param doctor 实例对象
     * @return 实例对象
     */
    Doctor insert(Doctor doctor);

    /**
     * 修改数据
     *
     * @param doctor 实例对象
     * @return 实例对象
     */
    Doctor update(Doctor doctor);

    /**
     * 通过主键删除数据
     *
     * @param doctorId 主键
     * @return 是否成功
     */
    boolean deleteById(String doctorId);

    Doctor queryByEmail(String email);
}
