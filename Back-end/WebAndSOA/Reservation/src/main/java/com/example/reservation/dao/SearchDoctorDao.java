package com.example.reservation.dao;

import com.example.reservation.entity.SearchDoctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SearchDoctorDao extends JpaRepository<SearchDoctor, String> {
    //查询医院列表
    @Query(value = "from SearchDoctor where doctor_id = ?1")
    SearchDoctor findByDoctor_id(String doctor_id);

    @Query(value = "from SearchDoctor where name = ?1")
    SearchDoctor findByName(String name);


    @Query(value = "from SearchDoctor where department_id= ?1")
    List<SearchDoctor> findByDepartment_id(Integer department_id);


    @Query(value = "from SearchDoctor ")
    List<SearchDoctor> findAll();
}
