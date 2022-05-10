package com.example.manageuser.Dao;

import com.example.manageuser.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorDao extends JpaRepository<Doctor, String>
{
    @Modifying
    @Query("delete from Doctor d where d.doctor_id=:doctor_id")
    Integer deleteByDoctor_id(@Param("doctor_id") String doctor_id);

    @Modifying
    @Query("delete from Doctor d where d.hospital_id=:hospital_id")
    Integer deleteByHospital_id(@Param("hospital_id") Integer hospital_id);

    @Query(value = "from Doctor where doctor_id = ?1")
    Doctor findDoctorByDoctor_id(String Id);
}
