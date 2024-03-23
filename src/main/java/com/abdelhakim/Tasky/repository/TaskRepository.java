package com.abdelhakim.Tasky.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abdelhakim.Tasky.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{  
}
