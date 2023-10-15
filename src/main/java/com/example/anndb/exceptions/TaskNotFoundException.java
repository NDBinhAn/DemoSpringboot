package com.example.anndb.exceptions;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(Long id) {
        super(String.valueOf(id));
    }
}
