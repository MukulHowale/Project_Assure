package com.constructweekproject.Assure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class LocationDoesNotExistException extends RuntimeException{
    public LocationDoesNotExistException(String message) {
        super(message);
    }
}
