package com.example.reservation.dao;



import com.example.reservation.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentDao extends JpaRepository<Department, Integer>
{
    //查询部门列表
    @Query(value = "from Department where department_id = ?1")
    Department findByDepartment_id(Integer department_id);


    @Query(value = "from Department where hospital_id= ?1")
    List<Department> findByHospital_id(Integer hospital_id);
}
