package com.example.mgnt_sys.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleTaskNotFound(UserNotFoundException ex) {
        return new ResponseEntity<>(new ErrorDetails("Task Not Found", ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleTaskNotFound(BookNotFoundException ex) {
        return new ResponseEntity<>(new ErrorDetails("Task Not Found", ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleGlobalException(Exception ex) {
        return new ResponseEntity<>(new ErrorDetails("Internal Server Error", ex.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
