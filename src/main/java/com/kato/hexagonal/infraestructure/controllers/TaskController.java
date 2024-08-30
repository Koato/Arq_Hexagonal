package com.kato.hexagonal.infraestructure.controllers;

import com.kato.hexagonal.application.services.TaskService;
import com.kato.hexagonal.domain.models.AdditionalTaskInfo;
import com.kato.hexagonal.domain.models.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    public TaskController(final TaskService taskService) {
        this.taskService = taskService;
    }

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task createdTask = taskService.createTask(task);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long taskId) {
        return taskService.getTask(taskId)
                .map(task -> new ResponseEntity<>(task, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable Long taskId, @RequestBody Task task) {
        return taskService.updateTask(taskId, task)
                .map(tsk -> new ResponseEntity<>(tsk, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable Long taskId) {
        if (taskService.deleteTask(taskId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{taskId}/additionalInfo")
    public ResponseEntity<AdditionalTaskInfo> getAllTasksByStatus(@RequestParam Long taskId) {
        AdditionalTaskInfo additionalTaskInfo = taskService.getAdditionalTaskInfo(taskId);
        return ResponseEntity.ok(additionalTaskInfo);
    }
}
