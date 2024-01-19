package com.fit.security.security.service;

import com.fit.security.entity.User;
import com.fit.security.exception.NotFoundException;
import com.fit.security.repository.UserRepositoty;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {


    private final UserRepositoty userRepositoty;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepositoty.findByEmail(username).orElseThrow(() -> {
            throw new NotFoundException("Email not found");
        });
        return UserDetailsImpl.userToUserDetails(user);
    }
}
