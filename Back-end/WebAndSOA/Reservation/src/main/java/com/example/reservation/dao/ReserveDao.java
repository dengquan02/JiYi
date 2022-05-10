package com.example.reservation.dao;

import com.example.reservation.entity.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReserveDao extends JpaRepository<Reserve, Integer>
{
    @Query(value = "from Reserve where patient = ?1")
    List<Reserve> findAllByPatient(String patient);



    @Modifying
    @Query("delete from Reserve n where n.reservation_id=:reservation_id")
    Integer deleteByReservation_id(@Param("reservation_id") Integer reservation_id);
}
