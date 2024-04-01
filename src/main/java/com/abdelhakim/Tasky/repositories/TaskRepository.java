package com.abdelhakim.Tasky.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abdelhakim.Tasky.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{  
}
