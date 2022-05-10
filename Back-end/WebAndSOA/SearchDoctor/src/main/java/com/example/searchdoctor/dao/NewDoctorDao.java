package com.example.searchdoctor.dao;

import com.example.searchdoctor.entity.NewDoctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NewDoctorDao extends JpaRepository<NewDoctor,String> {

    @Query(value = "from NewDoctor where hospital_id= ?1")
    List<NewDoctor> findNewByHospital_id(Integer hospital_id);
}
