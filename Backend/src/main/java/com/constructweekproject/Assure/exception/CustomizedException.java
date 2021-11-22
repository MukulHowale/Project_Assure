package com.constructweekproject.Assure.exception;

import com.constructweekproject.Assure.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class CustomizedException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidAgeOfMemberException.class)
    public final ResponseEntity<Object> handleInvalidAgeException(Exception e, WebRequest request) {
        ExceptionDTO ex = new ExceptionDTO(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserDoesNotExistException.class)
    public final ResponseEntity<Object> handleAuthenticationException(Exception e, WebRequest request) {
        ExceptionDTO ex = new ExceptionDTO(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(ex, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(PolicyDoesNotExistException.class)
    public final ResponseEntity<Object> handlePolicyException(Exception e, WebRequest request) {
        ExceptionDTO ex = new ExceptionDTO(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidEmailException.class)
    public final ResponseEntity<Object> handleInvalidEmailException(Exception e, WebRequest request) {
        ExceptionDTO ex = new ExceptionDTO(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(ex, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(InvalidMobileNumberException.class)
    public final ResponseEntity<Object> handleInvalidMobileException(Exception e, WebRequest request) {
        ExceptionDTO ex = new ExceptionDTO(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(ex, HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(InvalidGenderException.class)
    public final ResponseEntity<Object> handleInvalidGenderException(Exception e, WebRequest request) {
        ExceptionDTO ex = new ExceptionDTO(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InsufficientMemberDetailsException.class)
    public final ResponseEntity<Object> handleInsufficientDetailsException(Exception e, WebRequest request) {
        ExceptionDTO ex = new ExceptionDTO(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(ex, HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(InvalidRelationException.class)
    public final ResponseEntity<Object> handleInvalidRelationException(Exception e, WebRequest request) {
        ExceptionDTO ex = new ExceptionDTO(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(ex, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(DuplicateMemberException.class)
    public final ResponseEntity<Object> handleDuplicateMemberException(Exception e, WebRequest request) {
        ExceptionDTO ex = new ExceptionDTO(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(ex, HttpStatus.ALREADY_REPORTED);
    }

    @ExceptionHandler(CoverAmountNotSupportedException.class)
    public final ResponseEntity<Object> handleCoverAmountNotSupportedException(Exception e, WebRequest request) {
        ExceptionDTO ex = new ExceptionDTO(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CoverTenureNotSupportedException.class)
    public final ResponseEntity<Object> handleCoverTenureNotSupportedException(Exception e, WebRequest request) {
        ExceptionDTO ex = new ExceptionDTO(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidNameException.class)
    public final ResponseEntity<Object> handleInvalidNameException(Exception e, WebRequest request) {
        ExceptionDTO ex = new ExceptionDTO(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(ex, HttpStatus.CHECKPOINT);
    }

    @ExceptionHandler(InvalidPremiumException.class)
    public final ResponseEntity<Object> handleInvalidPremiumException(Exception e, WebRequest request) {
        ExceptionDTO ex = new ExceptionDTO(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(ex, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(InvalidAadhaarNumberException.class)
    public final ResponseEntity<Object> handleInvalidAadhaarException(Exception e, WebRequest request) {
        ExceptionDTO ex = new ExceptionDTO(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LocationDoesNotExistException.class)
    public final ResponseEntity<Object> handleInvalidLocationException(Exception e, WebRequest request) {
        ExceptionDTO ex = new ExceptionDTO(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(ex, HttpStatus.NOT_ACCEPTABLE);
    }
}
