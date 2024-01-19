package com.fit.security;

import com.fit.security.security.jwt.JwtService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecurityApplication{

	public static void main(String[] args) {

		SpringApplication.run(SecurityApplication.class, args);
	}

}
