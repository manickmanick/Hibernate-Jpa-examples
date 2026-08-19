package com.example.spring_security_learning.service;

import com.example.spring_security_learning.dto.CreateUserRequest;
import com.example.spring_security_learning.dto.UserResponse;
import com.example.spring_security_learning.entity.User;
import com.example.spring_security_learning.mapper.UserMapper;
import com.example.spring_security_learning.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponse createUser(CreateUserRequest request){
        User user = userMapper.toEntity(request);
        User savedUser = userRepository.save(user);
        return userMapper.toResponse(savedUser);
    }
}
