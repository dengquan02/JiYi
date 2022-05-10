package com.example.searchdoctor.dao;

import com.example.searchdoctor.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HospitalDao extends JpaRepository<Hospital, Integer> {

    //查询医院列表
    @Query(value = "from Hospital where hospital_id = ?1")
    Hospital findByHospital_id(Integer hospital_id);


    @Query(value = "from Hospital")
    List<Hospital> findAll();
}
