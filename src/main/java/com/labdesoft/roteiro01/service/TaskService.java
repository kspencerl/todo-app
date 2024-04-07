package com.labdesoft.roteiro01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labdesoft.roteiro01.entity.Task;
import com.labdesoft.roteiro01.entity.TaskStatus;
import com.labdesoft.roteiro01.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getTasksByStatus(TaskStatus status) {
        return taskRepository.findByStatus(status);
    }

    public List<Task> getTasksByLabel(String labelName) {
        return taskRepository.findByLabel_Name(labelName);
    }

    public List<Task> getTasksByCategory(String categoryName) {
        return taskRepository.findByCategoryName(categoryName);
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task updateTask(Long id, Task task) {
        Task existingTask = taskRepository.findById(id).orElse(null);
        if (existingTask != null) {
            existingTask.setName(task.getName());
            existingTask.setPriority(task.getPriority());
            existingTask.setLabel(task.getLabel());
            existingTask.setCategory(task.getCategory());
            existingTask.setDueDate(task.getDueDate());
            existingTask.setStatus(task.getStatus());
            
            return taskRepository.save(existingTask);
        }
        return existingTask;
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}