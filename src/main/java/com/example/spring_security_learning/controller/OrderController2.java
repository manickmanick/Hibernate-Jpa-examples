package com.example.spring_security_learning.controller;

import com.example.spring_security_learning.dto.OrderDetailResponse;
import com.example.spring_security_learning.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController2 {

    private final OrderService orderService;
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDetailResponse> getOrder(
            @PathVariable Long orderId
    ) {
        return ResponseEntity.ok(
                orderService.getOrder(orderId)
        );
    }
}
