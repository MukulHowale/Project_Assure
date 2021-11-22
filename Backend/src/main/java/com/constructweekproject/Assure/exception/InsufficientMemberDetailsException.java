package com.constructweekproject.Assure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class InsufficientMemberDetailsException extends RuntimeException{
    public InsufficientMemberDetailsException(String message) {
        super(message);
    }
}
