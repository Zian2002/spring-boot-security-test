package com.fit.security;

import com.fit.security.security.jwt.JwtService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class Test {
    public static void main(String[] args) {
        System.out.println("test");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("buinhutduyt001@gmail.com");
        message.setTo("justinduy81@gmail.com");
        message.setText("test gui mail");
        message.setSubject("Test");

    }
}
