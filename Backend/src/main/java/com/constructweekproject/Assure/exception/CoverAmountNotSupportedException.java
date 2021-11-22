package com.constructweekproject.Assure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CoverAmountNotSupportedException extends RuntimeException{
    public CoverAmountNotSupportedException(String message) {
        super(message);
    }
}
