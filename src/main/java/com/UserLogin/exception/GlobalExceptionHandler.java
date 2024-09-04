package com.UserLogin.exception;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorDetails> handlerUserAlreadyExists(UserAlreadyExistsException ex){
        ErrorDetails err = new ErrorDetails();
        err.setMsg(ex.getMessage());
        err.setDate(new Date());
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handlerResourceNotFound(ResourceNotFoundException ex){
        ErrorDetails err = new ErrorDetails();
        err.setMsg(ex.getMessage());
        err.setDate(new Date());
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

    }
}
