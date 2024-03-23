package com.abdelhakim.Tasky.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abdelhakim.Tasky.model.Task;
import com.abdelhakim.Tasky.repository.TaskRepository;

@Service
public class TaskService {
    
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task task) {
        if (taskRepository.findById(id).isPresent()){
            Task taskToUpdate = taskRepository.findById(id).get();
            taskToUpdate.setText(task.getText());
            taskToUpdate.setCompleted(task.getCompleted());
            taskRepository.save(task);
            return taskToUpdate;
        } else {
            return null;
        }
    }

    public void deleteTask(Long id) {
        if (taskRepository.findById(id).isPresent()){
            taskRepository.deleteById(id);
        }
    }
 
}
