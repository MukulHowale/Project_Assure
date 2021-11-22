package com.constructweekproject.Assure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidGenderException extends RuntimeException{
    public InvalidGenderException(String message) {
        super(message);
    }
}
