package com.example.spring_security_learning.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    public JwtAuthenticationFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String authorizationHeader = request.getHeader("Authorization");
        if(authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")){
            filterChain.doFilter(request, response);
            return;
        }

        // JWT processing will happen here
        String jwt =
                authorizationHeader.substring("Bearer ".length());

        // 4. Validate JWT
        if (!jwtService.isTokenValid(jwt)) {

            filterChain.doFilter(request, response);
            return;
        }

        // 5. Extract username
        String username =
                jwtService.extractUsername(jwt);

        // 6. Don't replace existing authentication
        if (SecurityContextHolder
                .getContext()
                .getAuthentication() == null) {

            // 7. Create authorities
            List<SimpleGrantedAuthority> authorities =
                    List.of(
                            new SimpleGrantedAuthority("ROLE_USER")
                    );

            // 8. Create authenticated Authentication object
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(
                            username,
                            null,
                            authorities
                    );

            // 9. Put authentication into SecurityContext
            SecurityContextHolder
                    .getContext()
                    .setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }
}
