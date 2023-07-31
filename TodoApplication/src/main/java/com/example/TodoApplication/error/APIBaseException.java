package com.example.TodoApplication.error;


import org.springframework.http.HttpStatus;

public abstract class APIBaseException extends RuntimeException {
    public APIBaseException(String message) {
        super(message);
    }
    public abstract HttpStatus getStatusCode();
}