package com.abdelhakim.Tasky.services;

import java.util.List;

import com.abdelhakim.Tasky.models.TaskRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abdelhakim.Tasky.models.Task;
import com.abdelhakim.Tasky.repositories.TaskRepository;

@Service
public class TaskService {
    
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task createTask(TaskRequest taskRequest) {
        Task task  = new Task();
        task.setText(taskRequest.getText());
        task.setCompleted(task.isCompleted());
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, TaskRequest taskRequest) {
        if (taskRepository.findById(id).isPresent()){
            Task taskToUpdate = taskRepository.findById(id).get();
            taskToUpdate.setText(taskRequest.getText());
            taskToUpdate.setCompleted(taskRequest.isCompleted());
            return taskRepository.save(taskToUpdate);
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
