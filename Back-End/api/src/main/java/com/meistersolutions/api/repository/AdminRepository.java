package com.meistersolutions.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meistersolutions.api.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    List<Admin> findById(int id);
    List<Admin> findByEmail(String email);
}
