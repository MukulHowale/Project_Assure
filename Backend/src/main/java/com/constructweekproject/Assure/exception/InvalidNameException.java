package com.constructweekproject.Assure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CHECKPOINT)
public class InvalidNameException extends RuntimeException{
    public InvalidNameException(String message) {
        super(message);
    }
}
