package com.example.spring_security_learning.controller;

import com.example.spring_security_learning.dto.LoginRequest;
import com.example.spring_security_learning.dto.RegisterRequest;
import com.example.spring_security_learning.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request){
        authService.register(request);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request){
        authService.login(request);
        return ResponseEntity.ok("Login sucessful");
    }
}
