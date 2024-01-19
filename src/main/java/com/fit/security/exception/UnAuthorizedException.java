package com.fit.security.exception;

import lombok.Data;

@Data
public class UnAuthorizedException extends RuntimeException{
    private int errorCode = 401;

    public UnAuthorizedException(String message){
        super(message);
    }

    public UnAuthorizedException(int errorCode, String message){
        super(message);
        this.errorCode = errorCode;
    }

}
