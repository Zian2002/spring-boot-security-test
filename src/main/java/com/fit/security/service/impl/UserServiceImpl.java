package com.fit.security.service.impl;

import com.fit.security.entity.Role;
import com.fit.security.entity.User;
import com.fit.security.exception.BadRequestException;
import com.fit.security.exception.NotFoundException;
import com.fit.security.model.request.LoginRequest;
import com.fit.security.model.request.RegisterRequest;
import com.fit.security.model.response.AuthenticationResponse;
import com.fit.security.repository.UserRepositoty;
import com.fit.security.security.jwt.JwtService;
import com.fit.security.service.UserService;
import com.fit.security.utils.BcryptUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepositoty userRepositoty;

    private final JwtService jwtService;

    @Override
    public UserDetailsService userDetailService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userRepositoty.findByEmail(username)
                        .orElseThrow(() -> new NotFoundException("Email not found"));
            }
        };
    }

    @Override
    public void registerUser(RegisterRequest request) {
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(BcryptUtils.hashPassword(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepositoty.save(user);
    }

    @Override
    public void registerAdmin(RegisterRequest request) {
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(BcryptUtils.hashPassword(request.getPassword()))
                .role(Role.ADMIN)
                .build();
        userRepositoty.save(user);
    }


    @Override
    public AuthenticationResponse login(LoginRequest request) {
        if (!userRepositoty.existsByEmail(request.getEmail())){
            throw new NotFoundException("Email not found");
        }

//        if (!userRepositoty.existsByEmailAndPassword(request.getEmail(),
//                BcryptUtils.hashPassword(request.getPassword()))){
//            throw new BadRequestException("Password not correct");
//        }

        User user = userRepositoty.findByEmail(request.getEmail()).get();

        if (BcryptUtils.verifyPassword(request.getPassword(), user.getPassword()))
            return AuthenticationResponse.builder()
                    .name(user.getName())
                    .email(user.getEmail())
                    .token(jwtService.generateToken(user.getEmail()))
                    .build();
        else throw new BadRequestException("Password not correct");
    }
}
