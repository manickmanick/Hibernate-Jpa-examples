package com.example.spring_security_learning.controller;

import com.example.spring_security_learning.dto.CreateOrderRequest;
import com.example.spring_security_learning.dto.OrderResponse;
import com.example.spring_security_learning.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users/{userId}/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(
            @PathVariable Long userId,
            @RequestBody CreateOrderRequest request
    ) {

        OrderResponse response =
                orderService.createOrder(userId, request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}