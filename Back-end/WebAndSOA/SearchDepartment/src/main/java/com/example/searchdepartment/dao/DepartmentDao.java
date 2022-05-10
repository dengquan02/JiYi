package com.example.searchdepartment.dao;


import com.example.searchdepartment.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentDao extends JpaRepository<Department, String>
{
    //查询部门列表
    @Query(value = "from Department where department_id = ?1")
    Department findByDepartment_id(Integer department_id);


    @Query(value = "from Department where hospital_id= ?1")
    List<Department> findByHospital_id(Integer hospital_id);

    @Modifying
    @Query("delete from Department d where d.hospital_id=:hospital_id")
    Integer deleteByHospital_id(@Param("hospital_id") Integer hospital_id);

}

