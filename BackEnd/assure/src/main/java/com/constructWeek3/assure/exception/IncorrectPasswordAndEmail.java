package com.constructWeek3.assure.exception;

public class IncorrectPasswordAndEmail extends RuntimeException {

    public IncorrectPasswordAndEmail(String msg) {
        super(msg);
    }

}
