package com.example.searchdepartment.dao;

import com.example.searchdepartment.entity.Department;
import com.example.searchdepartment.entity.NewDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author: Gu HungJou
 * @date: 2022/1/6 14:57
 * Describe:
 */
public interface NewDepartmentDao extends JpaRepository<NewDepartment, String> {

    @Query(value = "from NewDepartment where hospital_id= ?1")
    List<NewDepartment> findByHospital_id(Integer hospital_id);

}
