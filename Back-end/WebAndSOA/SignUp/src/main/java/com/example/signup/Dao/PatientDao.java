package com.example.signup.Dao;

import com.example.signup.Entity.Doctor;
import com.example.signup.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PatientDao extends JpaRepository<Patient, String>
{
    @Query(value = "from Patient where patient_id = ?1")
    Patient findPatientByPatient_id(String Id);
}
