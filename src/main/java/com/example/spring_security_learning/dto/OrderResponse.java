package com.example.spring_security_learning.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class OrderResponse {

    private Long id;
    private String productName;
    private BigDecimal amount;
    private Long userId;
}
