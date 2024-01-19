package com.fit.security.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuccessResponse {

    private Integer status;

    private String message;

    public SuccessResponse(String message) {
        this.status = 200;
        this.message = message;
    }
}
