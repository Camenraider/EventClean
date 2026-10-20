package com.joao.EventClean.infrastructure.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {
    
    @ExceptionHandler(DuplicateEventException.class)
    public ResponseEntity<Map<String, String>> handleDuplicateEventExceptions(DuplicateEventException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("Error", ex.getMessage());
        response.put("Message", "Please, insert a valid hashId for your event and try again");
        return new ResponseEntity<Map<String, String>>(response, HttpStatus.CONFLICT);
    }
}
