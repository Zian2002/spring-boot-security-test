package com.fit.security.exception;

import lombok.Data;

@Data
public class MethodNotAllowedException extends RuntimeException {

    private int errorCode = 405;
    public MethodNotAllowedException(int errorCode, String message){
        super(message);
        this.errorCode = errorCode;
    }

    public MethodNotAllowedException(String message){
        super(message);
    }
}
