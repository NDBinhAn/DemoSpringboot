package com.example.anndb.services;

import com.example.anndb.dtos.TaskRequestDto;
import com.example.anndb.dtos.TaskResponseDto;
import com.example.anndb.entities.TaskEntity;
import com.example.anndb.exceptions.TaskNotFoundException;
import com.example.anndb.mappers.TaskMapper;
import com.example.anndb.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }
    public boolean containByID(Long id) {
        return taskRepository.existsById(id);
    }
    public TaskResponseDto findByID(Long id) throws TaskNotFoundException {
        TaskEntity existingTaskEntity = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        return taskMapper.taskEntityToTaskResponseDto(existingTaskEntity);
    }
    public List<TaskResponseDto> getAll() {
        return taskRepository.findAll().stream().map(taskMapper::taskEntityToTaskResponseDto).toList();
    }
    public TaskResponseDto createTask(TaskRequestDto taskRequestDto) {
        TaskEntity taskEntity = taskMapper.taskRequestDtoToTaskEntity(taskRequestDto);
        taskRepository.save(taskEntity);
        return taskMapper.taskEntityToTaskResponseDto(taskEntity);
    }
    public TaskResponseDto updateTask(TaskRequestDto taskRequestDto, Long id) throws TaskNotFoundException {
        TaskEntity existingTaskEntity = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        existingTaskEntity.setTitle(taskRequestDto.title());
        existingTaskEntity.setDescription(taskRequestDto.description());
        existingTaskEntity.setCompleted(taskRequestDto.completed());
        taskRepository.save(existingTaskEntity);
        return taskMapper.taskEntityToTaskResponseDto(existingTaskEntity);
    }
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
