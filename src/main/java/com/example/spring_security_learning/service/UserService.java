package com.example.spring_security_learning.service;

import com.example.spring_security_learning.dto.CreateUserRequest;
import com.example.spring_security_learning.dto.UserResponse;
import com.example.spring_security_learning.entity.User;
import com.example.spring_security_learning.mapper.UserMapper;
import com.example.spring_security_learning.repository.UserRepository;
import com.example.spring_security_learning.specification.UserSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional(readOnly = true)
    public UserResponse getUser(Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("User not found"));
        return userMapper.toResponse(user);
    }

    @Transactional(readOnly = true)
    public List<UserResponse> testNPlusOne() {

//        List<User> users = userRepository.findAll();

        List<User> users = userRepository.findAllWithOrders();
//        System.out.println(users);
//        System.out.println("===========================================================================");
//        for (User user : users) {
//
//            System.out.println(
//                    user.getName() +
//                            " -> " +
//                            user.getOrders().size()+
//                            " orders"
//            );
//        }
        return users.stream()
                .map(userMapper::toResponse)
                .toList();

//        return users;
    }


    @Transactional(readOnly = true)
    public Page<UserResponse> searchByName(String name,String email,Pageable pageable){
        Specification<User> specification = Specification
                .where(UserSpecification.hasName(name))
                .or(UserSpecification.hasEmail(email));

        Page<User> users = userRepository.findAll(specification,pageable);

        return users.map(userMapper::toResponse);
    }

    @Transactional(readOnly = true)
    public Page<UserResponse> getUsers(Pageable pageable){
        Page<User> users = userRepository.findAll(pageable);
        return users.map(userMapper::toResponse);
    }

    @Transactional
    public UserResponse updateUserName(Long id,String name){
        User user = userRepository.findById(id).orElseThrow(
                ()->new RuntimeException("User not found")
        );
        user.setName(name);
        return userMapper.toResponse(user);
    }
}
