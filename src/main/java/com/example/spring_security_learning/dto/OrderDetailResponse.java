package com.example.spring_security_learning.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class OrderDetailResponse {
    private Long id;
    private String productName;
    private BigDecimal amount;
    private UserSummary user;
}
