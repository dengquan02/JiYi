package com.example.login.Dao;

import com.example.login.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminDao extends JpaRepository<Admin,Integer> {
    @Query(value = "from Admin where name = ?1")
    Admin findByName(String name);
}
