package com.example.manageuser.Dao;

import com.example.manageuser.Entity.Doctor;
import com.example.manageuser.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDao extends JpaRepository<Patient, String>
{
    @Modifying
    @Query("delete from Patient d where d.patient_id=:patinet_id")
    Integer deleteByPatient_id(@Param("patinet_id") String patinet_id);

    @Query(value = "from Patient where patient_id = ?1")
    Patient findPatientByPatient_id(String Id);
}
