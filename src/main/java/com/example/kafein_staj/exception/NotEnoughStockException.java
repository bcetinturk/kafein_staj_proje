package com.example.kafein_staj.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Trying to buy item more than in the stock")
public class NotEnoughStockException extends Exception{
    public NotEnoughStockException(String message) {
        super(message);
    }
}
