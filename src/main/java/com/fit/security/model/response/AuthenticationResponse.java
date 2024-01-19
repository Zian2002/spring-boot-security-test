package com.fit.security.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationResponse {
    private String token;

    private String email;

    private String name;
}
