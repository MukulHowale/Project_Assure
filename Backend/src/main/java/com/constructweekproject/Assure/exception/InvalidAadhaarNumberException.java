package com.constructweekproject.Assure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidAadhaarNumberException extends RuntimeException{
    public InvalidAadhaarNumberException(String message) {
        super(message);
    }
}
