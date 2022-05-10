package com.example.reservation.dao;

import com.example.reservation.entity.Arrange;
import com.example.reservation.entity.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArrangeDao extends JpaRepository<Arrange, Integer>
{
    @Query(value = "from Arrange where day = ?1 and hospital_id = ?2 and department_id = ?3")
    List<Arrange> findAllByDayAndHospital_idAndDepartment_id(String day, Integer hospital_id, Integer department_id);

    @Query(value = "from Arrange where day = ?1 and doctor_id = ?2")
    List<Arrange> findAllByDayAndDoctor_id(String day, String doctor_id);

    @Query(value = "from Arrange where doctor_id = ?1")
    List<Arrange> findAllByDoctor(@Param("doctor_id") String doctorId );;
}
