package com.example.spring_security_learning.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreateOrderRequest {
    private String productName;
    private BigDecimal amount;
}
