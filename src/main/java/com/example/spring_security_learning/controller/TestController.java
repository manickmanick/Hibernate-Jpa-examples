//package com.example.spring_security_learning.controller;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class TestController {
//
//    @GetMapping("/hello")
//    public String hello() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println(authentication);
//        System.out.println("==============================================================================");
//        System.out.println(authentication.getName());
//        return "Hello spring security";
//    }
//
//    @GetMapping("/public")
//    public String publicApi() {
//        return "This is public";
//    }
//
//    @GetMapping("/private")
//    public String privateApi() {
//        return "This is a private API";
//    }
//}
