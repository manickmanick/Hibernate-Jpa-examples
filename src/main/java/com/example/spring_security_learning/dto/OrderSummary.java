package com.example.spring_security_learning.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class OrderSummary {
    private Long id;
    private String productName;
    private BigDecimal amount;
}
