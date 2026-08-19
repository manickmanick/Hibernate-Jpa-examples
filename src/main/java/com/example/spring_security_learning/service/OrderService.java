package com.example.spring_security_learning.service;

import com.example.spring_security_learning.dto.CreateOrderRequest;
import com.example.spring_security_learning.dto.OrderResponse;
import com.example.spring_security_learning.entity.Order;
import com.example.spring_security_learning.entity.User;
import com.example.spring_security_learning.mapper.OrderMapper;
import com.example.spring_security_learning.repository.OrderRepository;
import com.example.spring_security_learning.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final OrderMapper orderMapper;

    @Transactional
    public OrderResponse createOrder(Long userId, CreateOrderRequest request){
        User user = userRepository.findById(userId).orElseThrow(() ->
                new RuntimeException("User not found"));

        Order order = orderMapper.toEntity(request);

        user.addOrder(order);

        Order savedOrder = orderRepository.save(order);

        return orderMapper.toResponse(savedOrder);

    }
}
