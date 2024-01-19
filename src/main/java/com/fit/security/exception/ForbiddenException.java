package com.fit.security.exception;

import lombok.Data;

@Data
public class ForbiddenException extends RuntimeException {
    private int errorCode = 403;

    public ForbiddenException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ForbiddenException(String message) {
        super(message);
    }

}
