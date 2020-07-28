package com.example.kafein_staj.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Category is using in Products")
public class UsedCategoryException extends Exception {
    public UsedCategoryException(String message){super(message);}
}