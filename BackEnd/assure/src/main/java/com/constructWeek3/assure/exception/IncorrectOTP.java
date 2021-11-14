package com.constructWeek3.assure.exception;

public class IncorrectOTP extends RuntimeException {

    public IncorrectOTP(String message) {
        super(message);
    }
}
