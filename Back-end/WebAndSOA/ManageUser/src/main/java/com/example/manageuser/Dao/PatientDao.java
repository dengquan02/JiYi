package com.example.manageuser.dao;

import com.example.manageuser.entity.Patient;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Patient)表数据库访问层
 *
 * @author makejava
 * @since 2022-05-13 19:36:33
 */
public interface PatientDao {

    /**
     * 通过ID查询单条数据
     *
     * @param patientId 主键
     * @return 实例对象
     */
    Patient queryById(String patientId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Patient> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);



    List<Patient> queryAll();

    /**
     * 新增数据
     *
     * @param patient 实例对象
     * @return 影响行数
     */
    int insert(Patient patient);

    /**
     * 修改数据
     *
     * @param patient 实例对象
     * @return 影响行数
     */
    int update(Patient patient);

    /**
     * 通过主键删除数据
     *
     * @param patientId 主键
     * @return 影响行数
     */
    int deleteById(String patientId);

}
