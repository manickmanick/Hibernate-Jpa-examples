package com.example.spring_security_learning.mapper;

import com.example.spring_security_learning.dto.CreateUserRequest;
import com.example.spring_security_learning.dto.UserResponse;
import com.example.spring_security_learning.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(CreateUserRequest request){
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        return user;
    }

    public UserResponse toResponse(User user){
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}
