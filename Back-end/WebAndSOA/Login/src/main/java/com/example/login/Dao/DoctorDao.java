package com.example.login.Dao;

import com.example.login.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DoctorDao extends JpaRepository<Doctor, String>
{
    @Query(value = "from Doctor where doctor_id = ?1")
    Doctor findDoctorByDoctor_id(String Id);
}
