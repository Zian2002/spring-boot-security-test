package com.fit.security.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptUtils {
    private static final BCryptPasswordEncoder B_CRYPT_PASSWORD_ENCODER = new BCryptPasswordEncoder();

    public static String hashPassword(String plainTextPassword){
        return B_CRYPT_PASSWORD_ENCODER.encode(plainTextPassword);
    }

    public static boolean verifyPassword(String plainTextPassword, String hashPassword){
        return B_CRYPT_PASSWORD_ENCODER.matches(plainTextPassword, hashPassword);
    }
}
