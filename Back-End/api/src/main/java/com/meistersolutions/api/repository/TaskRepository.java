package com.meistersolutions.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meistersolutions.api.entity.Admin;
import com.meistersolutions.api.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findByAdmin_id(Integer id);

    List<Task> findByAdmin(Admin admin);

    List<Task> findById(int id);
}
