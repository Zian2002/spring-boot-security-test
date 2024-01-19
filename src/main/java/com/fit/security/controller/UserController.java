package com.fit.security.controller;

import com.fit.security.model.request.LoginRequest;
import com.fit.security.model.request.RegisterRequest;
import com.fit.security.model.response.AuthenticationResponse;
import com.fit.security.service.UserService;
import com.fit.security.utils.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Autowired
    private final AuthenticationManager authenticationManager;

    @PostMapping("/registerUser")
    public ResponseEntity<SuccessResponse> registerUser(@RequestBody RegisterRequest registerRequest){
        userService.registerUser(registerRequest);
        return ResponseEntity.ok(new SuccessResponse("Create successfully"));
    }

    @PostMapping("/registerAdmin")
    public ResponseEntity<SuccessResponse> registerAdmin(@RequestBody RegisterRequest registerRequest){
        userService.registerAdmin(registerRequest);
        return ResponseEntity.ok(new SuccessResponse("Create successfully"));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest request){
        AuthenticationResponse response = userService.login(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user")
    public ResponseEntity<String> secret(){
        return ResponseEntity.ok("hi user");
    }

    @GetMapping("/admin")
    public ResponseEntity<String> secret2(){
        return ResponseEntity.ok("hi admin");
    }

    @GetMapping("/authen")
    public ResponseEntity<String> authen(){
        return ResponseEntity.ok("authen");
    }




}
