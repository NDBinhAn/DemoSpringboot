package com.example.anndb.mappers;

import com.example.anndb.dtos.TaskRequestDto;
import com.example.anndb.dtos.TaskResponseDto;
import com.example.anndb.entities.TaskEntity;
import org.springframework.stereotype.Component;
//import org.mapstruct.Mapper;

//@Mapper(componentModel = "spring")
//public interface TaskMapper {
//    TaskResponseDto taskEntityToTaskResponseDto(TaskEntity taskEntity);
//    TaskEntity taskRequestDtoToTaskEntity(TaskRequestDto taskRequestDto);
//}


@Component
public class TaskMapper{
    public TaskMapper() {
    }

    public TaskResponseDto taskEntityToTaskResponseDto(TaskEntity taskEntity) {
        if (taskEntity == null) {
            return null;
        } else {
            Long id = null;
            String title = null;
            String description = null;
            Boolean completed = null;
            id = taskEntity.getId();
            title = taskEntity.getTitle();
            description = taskEntity.getDescription();
            completed = taskEntity.getCompleted();
            TaskResponseDto taskResponseDto = new TaskResponseDto(id, title, description, completed);
            return taskResponseDto;
        }
    }

    public TaskEntity taskRequestDtoToTaskEntity(TaskRequestDto taskRequestDto) {
        if (taskRequestDto == null) {
            return null;
        } else {
            String title = null;
            String description = null;
            Boolean completed = null;
            title = taskRequestDto.title();
            description = taskRequestDto.description();
            completed = taskRequestDto.completed();
            Long id = null;
            TaskEntity taskEntity = new TaskEntity((Long)id, title, description, completed);
            return taskEntity;
        }
    }
}
