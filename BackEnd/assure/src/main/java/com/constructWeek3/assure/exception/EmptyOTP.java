package com.constructWeek3.assure.exception;

public class EmptyOTP extends RuntimeException {

    public EmptyOTP(String message) {
        super(message);
    }
}
