package com.example.spring_security_learning.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String name;
    private String email;
//    private List<OrderSummary> orders;
}
