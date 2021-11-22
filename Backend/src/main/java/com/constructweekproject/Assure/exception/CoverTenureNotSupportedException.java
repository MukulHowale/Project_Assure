package com.constructweekproject.Assure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CoverTenureNotSupportedException extends RuntimeException{
    public CoverTenureNotSupportedException(String message) {
        super(message);
    }
}
