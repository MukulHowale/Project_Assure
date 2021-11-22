package com.constructweekproject.Assure.exception;

public class EmptyOTP extends RuntimeException {

    public EmptyOTP(String message) {
        super(message);
    }
}
