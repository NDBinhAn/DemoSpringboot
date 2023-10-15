package com.example.anndb.dtos;
public record TaskRequestDto(String title, String description, Boolean completed) {
}
//import jakarta.annotation.Nullable;
//
//public class TaskRequestDto {
//
//    private final String title;
//    @Nullable
//    private final String description;
//    private final Boolean completed;
//    public TaskRequestDto(String title, @Nullable String description, Boolean completed) {
//        this.title = title;
//        this.description = description;
//        this.completed = completed;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    @Nullable
//    public String getDescription() {
//        return description;
//    }
//
//    public Boolean getCompleted() {
//        return completed;
//    }
//}
