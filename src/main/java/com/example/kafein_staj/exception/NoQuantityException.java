package com.example.kafein_staj.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Product Quantity is zero")
public class NoQuantityException extends Exception {
    public NoQuantityException(String message){super(message);}
}
