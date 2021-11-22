package com.constructweekproject.Assure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
public class InvalidMobileNumberException extends RuntimeException{
    public InvalidMobileNumberException(String message) {
        super(message);
    }
}
