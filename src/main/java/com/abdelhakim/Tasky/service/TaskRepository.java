package com.abdelhakim.Tasky.service;

import com.abdelhakim.Tasky.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}

