package com.example.searchdoctor.dao;

import com.example.searchdoctor.entity.SearchDoctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SearchDoctorDao extends JpaRepository<SearchDoctor, String> {
    //查询医院列表
    @Query(value = "from SearchDoctor where doctor_id = ?1")
    SearchDoctor findByDoctor_id(String doctor_id);

    @Query(value = "from SearchDoctor where department_id= ?1")
    List<SearchDoctor> findByDepartment_id(Integer department_id);

    @Query(value = "from SearchDoctor where hospital_id= ?1")
    List<SearchDoctor> findByHospital_id(Integer hospital_id);

    @Query(value = "from SearchDoctor ")
    List<SearchDoctor> findAll();
}
