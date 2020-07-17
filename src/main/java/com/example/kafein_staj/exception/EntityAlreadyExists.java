package com.example.kafein_staj.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Entity already exists.")
public class EntityAlreadyExists extends Exception{
    public EntityAlreadyExists(String message) {
        super(message);
    }
}
