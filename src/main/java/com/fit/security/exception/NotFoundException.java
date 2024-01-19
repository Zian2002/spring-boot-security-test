package com.fit.security.exception;

import lombok.Data;
import org.aspectj.weaver.ast.Not;

@Data
public class NotFoundException extends RuntimeException{
    private int errorCode = 404;

    public NotFoundException(int errorCode, String message){
        super(message);
        this.errorCode = errorCode;
    }

    public NotFoundException(String message){
        super(message);
    }

}
