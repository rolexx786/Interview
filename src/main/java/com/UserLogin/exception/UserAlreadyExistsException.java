package com.UserLogin.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;


public class UserAlreadyExistsException  extends RuntimeException{
    public UserAlreadyExistsException(String msg){
        super(msg);
    }
}
