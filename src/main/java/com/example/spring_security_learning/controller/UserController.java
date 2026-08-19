package com.example.spring_security_learning.controller;

import com.example.spring_security_learning.dto.CreateUserRequest;
import com.example.spring_security_learning.dto.UserResponse;
import com.example.spring_security_learning.entity.User;
import com.example.spring_security_learning.service.UserService;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(
            @RequestBody CreateUserRequest request
    ) {

        UserResponse response = userService.createUser(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long userId){
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @GetMapping("/test-n-plus-one")
    public ResponseEntity<List<UserResponse>> testNPlusOne() {

        List<UserResponse> users = userService.testNPlusOne();

        return ResponseEntity.ok(users);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<UserResponse>> searchUsers(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            Pageable pageable){
        return ResponseEntity.ok(userService.searchByName(name,email,pageable));
    }

    @GetMapping("/page")
    public ResponseEntity<Page<UserResponse>> getUsers(
            Pageable pageable
    ) {

        return ResponseEntity.ok(
                userService.getUsers(pageable)
        );
    }

    @PutMapping("/{id}/name")
    public ResponseEntity<UserResponse> updateUserName(
            @PathVariable Long id,
            @RequestParam String name
    ) {

        return ResponseEntity.ok(
                userService.updateUserName(id, name)
        );
    }

}
