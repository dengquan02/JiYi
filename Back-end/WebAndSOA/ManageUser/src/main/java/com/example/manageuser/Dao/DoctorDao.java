package com.example.manageuser.dao;

import com.example.manageuser.entity.Department;
import com.example.manageuser.entity.Doctor;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Doctor)表数据库访问层
 *
 * @author makejava
 * @since 2022-05-13 19:35:51
 */
public interface DoctorDao {

    /**
     * 通过ID查询单条数据
     *
     * @param doctorId 主键
     * @return 实例对象
     */
    Doctor queryById(String doctorId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Doctor> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    List<Department> queryByDepartmentId(@Param("departmentId") Integer departmentId);

    List<Department> queryByHospitalId(@Param("hospitalId") Integer hospitalId);

    List<Doctor> queryAll();

    /**
     * 新增数据
     *
     * @param doctor 实例对象
     * @return 影响行数
     */
    int insert(Doctor doctor);

    /**
     * 修改数据
     *
     * @param doctor 实例对象
     * @return 影响行数
     */
    int update(Doctor doctor);

    /**
     * 通过主键删除数据
     *
     * @param doctorId 主键
     * @return 影响行数
     */
    int deleteById(String doctorId);

}
