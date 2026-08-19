package com.example.spring_security_learning.service;

import com.example.spring_security_learning.dto.LoginRequest;
import com.example.spring_security_learning.dto.RegisterRequest;
import com.example.spring_security_learning.entity.User;
import com.example.spring_security_learning.repository.UserRepository;
import com.example.spring_security_learning.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository,PasswordEncoder passwordEncoder
    ,AuthenticationManager authenticationManager,
                       JwtService jwtService){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public void register(RegisterRequest request){
        User user = new User();

        String encodedPassword = passwordEncoder.encode(request.getPassword());

        user.setName(request.getUsername());
        user.setPassword(encodedPassword);
        user.setRole("USER");
        userRepository.save(user);

    }

    public String login(LoginRequest request){
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        );
       Authentication authentication = authenticationManager.authenticate(token);
        System.out.println( authentication);
       return jwtService.generateToken(authentication.getName());
    }
}
