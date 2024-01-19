package com.fit.security.service;

import com.fit.security.entity.User;
import com.fit.security.model.request.LoginRequest;
import com.fit.security.model.request.RegisterRequest;
import com.fit.security.model.response.AuthenticationResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {

    UserDetailsService userDetailService();

    void registerUser(RegisterRequest request);

    void registerAdmin(RegisterRequest request);

    AuthenticationResponse login(LoginRequest request);

}
