package com.constructweekproject.Assure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class DuplicateMemberException extends RuntimeException{
    public DuplicateMemberException(String message) {
        super(message);
    }
}
