package com.example.searchhospital.dao;

import com.example.searchhospital.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HospitalDao extends JpaRepository<Hospital, Integer> {

    //查询医院列表
    @Query(value = "from Hospital where hospital_id = ?1")
    Hospital findByHospital_id(Integer hospital_id);


    @Query(value = "from Hospital")
    List<Hospital> findAll();

    @Modifying
    @Query("delete from Hospital d where d.hospital_id=:hospital_id")
    Integer deleteByHospital_id(@Param("hospital_id") Integer hospital_id);


}
