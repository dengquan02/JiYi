package com.example.login.Dao;

import com.example.login.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PatientDao extends JpaRepository<Patient, String>
{
    @Query(value = "from Patient where patient_id = ?1")
    Patient findPatientByPatient_id(String Id);
}
