package com.constructweekproject.Assure.exception;

import com.constructweekproject.Assure.dto.ExceptionResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityException extends ResponseEntityExceptionHandler {

    // Handles all exception
    @ExceptionHandler(Exception.class)
    public final ResponseEntity handleAllException(Exception e, WebRequest webRequest){

        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),
                e.getMessage(), webRequest.getDescription(false));

        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Handles if the user email/mobile already exists
    @ExceptionHandler(UserExists.class)
    public final ResponseEntity handleUserExistException(Exception e, WebRequest webRequest){

        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),
                e.getMessage(), webRequest.getDescription(false));

        return new ResponseEntity(exceptionResponse, HttpStatus.ALREADY_REPORTED);
    }

    // Handles if the otp is incorrect
    @ExceptionHandler(IncorrectOTP.class)
    public final ResponseEntity handleIncorrectOTPException(Exception e, WebRequest webRequest){

        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),
                e.getMessage(), webRequest.getDescription(false));

        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    // Handles if otp is not entered
    @ExceptionHandler(EmptyOTP.class)
    public final ResponseEntity handleEmptyOTPException(Exception e, WebRequest webRequest){

        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),
                e.getMessage(), webRequest.getDescription(false));

        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    //handles empty values sent and name and password length check
    @ExceptionHandler(EmptyInputException.class)
    public final ResponseEntity handleEmptyInputException(Exception e, WebRequest webRequest){

        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),
                e.getMessage(), webRequest.getDescription(false));

        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    // (Login)
    // Handles if the password and email is incorrect
    @ExceptionHandler(IncorrectPasswordAndEmail.class)
    public final ResponseEntity handleIncorrectPasswordAndEmailException(Exception e, WebRequest webRequest){

        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),
                e.getMessage(), webRequest.getDescription(false));

        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }





    //Exception for incorrect path
    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
                                                                   HttpStatus status, WebRequest webRequest) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),
                "The path is incorrect", webRequest.getDescription(false));

        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    //Exception if body is not presented
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),
                "Body does not exist", request.getDescription(false));

        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
