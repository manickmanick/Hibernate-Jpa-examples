package com.example.spring_security_learning.mapper;

import com.example.spring_security_learning.dto.CreateOrderRequest;
import com.example.spring_security_learning.dto.OrderDetailResponse;
import com.example.spring_security_learning.dto.OrderResponse;
import com.example.spring_security_learning.dto.UserSummary;
import com.example.spring_security_learning.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public Order toEntity(CreateOrderRequest request){
        Order order = new Order();
        order.setProductName(request.getProductName());
        order.setAmount(request.getAmount());
        return order;
    }

    public OrderResponse toResponse(Order order){
        return new OrderResponse(
                order.getId(),
                order.getProductName(),
                order.getAmount(),
                order.getUser().getId()
        );
    }

    public OrderDetailResponse toDetailResponse(Order order){
        UserSummary user = new UserSummary(
                order.getUser().getId(),
                order.getUser().getName(),
                order.getUser().getEmail()
        );
        return new OrderDetailResponse(
                order.getId(),
                order.getProductName(),
                order.getAmount(),
                user
        );
    }

}
