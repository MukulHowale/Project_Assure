package com.constructWeek3.assure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class InvalidRelationException extends RuntimeException{
    public InvalidRelationException(String message) {
        super(message);
    }
}
