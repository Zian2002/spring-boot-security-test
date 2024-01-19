package com.fit.security.exception;

import lombok.Data;

@Data
public class BadRequestException extends RuntimeException {
    private int errorCode = 400;

    public BadRequestException(int errorCode,String message ) {
        super(message);
        this.errorCode = errorCode;
    }

    public BadRequestException(String message) {
        super(message);
    }
}
