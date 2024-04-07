package com.labdesoft.roteiro01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.labdesoft.roteiro01.entity.Task;
import com.labdesoft.roteiro01.entity.TaskStatus;
import com.labdesoft.roteiro01.service.TaskService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/all")
    @Operation(summary = "Lista todas as tarefas existentes.")
    public ResponseEntity<List<Task>> findAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok().body(tasks);
    }

    @GetMapping("/{status}")
    @Operation(summary = "Lista todas as tarefas da lista de um status específico")
    public ResponseEntity<List<Task>> findTasksByStatus(@PathVariable TaskStatus status) {
        List<Task> tasks = taskService.getTasksByStatus(status);
        return ResponseEntity.ok().body(tasks);
    }

    @GetMapping("/byLabel/{labelName}")
    @Operation(summary = "Lista todas as tarefas com uma label específica")
    public ResponseEntity<List<Task>> findTasksByLabel(@PathVariable String labelName) {
        List<Task> tasks = taskService.getTasksByLabel(labelName);
        return ResponseEntity.ok().body(tasks);
    }

    @GetMapping("/byCategory/{categoryName}")
    @Operation(summary = "Lista todas as tarefas com uma categoria específica")
    public ResponseEntity<List<Task>> findTasksByCategory(@PathVariable String categoryName) {
        List<Task> tasks = taskService.getTasksByCategory(categoryName);
        return ResponseEntity.ok().body(tasks);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Lista uma tarefa específica")
    public ResponseEntity<Task> findTaskById(@PathVariable Long id) {
        Task task = taskService.getTaskById(id);
        if (task != null) {
            return ResponseEntity.ok().body(task);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    @Operation(summary = "Adiciona uma nova tarefa")
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        Task addedTask = taskService.addTask(task);
        return ResponseEntity.ok().body(addedTask);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Atualiza uma tarefa existente")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        Task updatedTask = taskService.updateTask(id, task);
        if (updatedTask != null) {
            return ResponseEntity.ok().body(updatedTask);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Exclui uma tarefa existente")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
