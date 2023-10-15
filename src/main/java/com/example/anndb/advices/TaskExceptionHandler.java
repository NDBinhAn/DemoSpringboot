package com.example.anndb.advices;

import com.example.anndb.exceptions.TaskNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class TaskExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({TaskNotFoundException.class})
    protected ResponseEntity<Object> handleNotFound(Exception ex, WebRequest webRequest) {
        String body = "NOT FOUND TASK ID " + ex.getMessage();
        return handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.NOT_FOUND, webRequest);
    }
}
