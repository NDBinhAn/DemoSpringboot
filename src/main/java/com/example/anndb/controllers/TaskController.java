package com.example.anndb.controllers;

import com.example.anndb.dtos.TaskRequestDto;
import com.example.anndb.dtos.TaskResponseDto;
import com.example.anndb.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController{
    private final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping(value = "/tasks")
    public List<TaskResponseDto> getAllTasks() {
        return taskService.getAll();
    }
    @PostMapping(value = "/tasks")
    public ResponseEntity<TaskResponseDto> createTask(@RequestBody TaskRequestDto taskRequestDto) {
        TaskResponseDto taskResponseDto = taskService.createTask(taskRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskResponseDto);
    }
    @GetMapping(value = "/tasks/{id}")
    public ResponseEntity<TaskResponseDto> getTaskById(@PathVariable("id") Long id) {
        TaskResponseDto taskResponseDto = taskService.findByID(id);
        return ResponseEntity.status(HttpStatus.OK).body(taskResponseDto);
    }
    @PutMapping(value = "/tasks/{id}")
    public ResponseEntity<TaskResponseDto> updateTask(@PathVariable("id") Long id, @RequestBody TaskRequestDto taskRequestDto) {
        if (taskService.containByID(id)) {
            TaskResponseDto taskResponseDto = taskService.updateTask(taskRequestDto, id);
            return ResponseEntity.status(HttpStatus.OK).body(taskResponseDto);
        } else {
            TaskResponseDto taskResponseDto = taskService.createTask(taskRequestDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(taskResponseDto);
        }
    }
    @DeleteMapping(value = "/tasks/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.status(HttpStatus.OK).body("Delete Task " + id + " successfully");
    }
}
