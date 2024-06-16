package com.labdesoft.roteiro01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.labdesoft.roteiro01.entity.Task;
import com.labdesoft.roteiro01.service.TaskService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    @Operation(summary = "Lista todas as tarefas existentes.")
    public ResponseEntity<List<Task>> findAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok().body(tasks);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Listar tarefa específica")
    public ResponseEntity<Task> findTaskById(@PathVariable Long id) {
        Task task = taskService.getTaskById(id);
        if (task != null) {
            return ResponseEntity.ok().body(task);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    @Operation(summary = "Adicionar nova tarefa")
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        Task addedTask = taskService.addTask(task);
        return ResponseEntity.ok().body(addedTask);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Atualizar tarefa existente")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        Task updatedTask = taskService.updateTask(id, task);
        if (updatedTask != null) {
            return ResponseEntity.ok().body(updatedTask);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Excluir tarefa existente")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}