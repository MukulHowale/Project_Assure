package com.constructWeek3.assure.exception;

public class UserExists extends RuntimeException {

    public UserExists(String message) {
        super(message);
    }
}
