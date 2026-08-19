//package com.example.spring_security_learning.controller;
//
//import com.example.spring_security_learning.dto.LoginRequest;
//import com.example.spring_security_learning.dto.LoginResponse;
//import com.example.spring_security_learning.dto.RegisterRequest;
//import com.example.spring_security_learning.service.AuthService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/auth")
//public class AuthController {
//
//    private final AuthService authService;
//
//    public AuthController(AuthService authService) {
//        this.authService = authService;
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity<String> register(
//            @RequestBody RegisterRequest request) {
//
////        authService.register(request);
//
//        return ResponseEntity.ok(
//                "User registered successfully"
//        );
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<LoginResponse> login(
//            @RequestBody LoginRequest request) {
//
//        String token = authService.login(request);
//
//        return ResponseEntity.ok(
//                new LoginResponse(token)
//        );
//    }
//}