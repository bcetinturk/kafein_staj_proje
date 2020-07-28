package com.example.kafein_staj.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Operation not allowed.")
public class IllegalOperationException extends Exception {
    public IllegalOperationException(String message) {
        super(message);
    }
}
