package com.example.spring_security_learning.mapper;

import com.example.spring_security_learning.dto.CreateUserRequest;
import com.example.spring_security_learning.dto.OrderSummary;
import com.example.spring_security_learning.dto.UserResponse;
import com.example.spring_security_learning.entity.User;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserMapper {

    public User toEntity(CreateUserRequest request){
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        return user;
    }

    public UserResponse toResponse(User user){

//        var orders = user.getOrders().stream()
//                .map(order -> new OrderSummary(
//                        order.getId(),
//                        order.getProductName(),
//                        order.getAmount()
//                )).collect(Collectors.toList());
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail()
//                orders
        );
    }
}
