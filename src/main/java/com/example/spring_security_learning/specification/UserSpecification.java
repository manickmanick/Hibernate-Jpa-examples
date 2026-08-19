package com.example.spring_security_learning.specification;

import com.example.spring_security_learning.entity.User;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {

    public static Specification<User> hasName(String name){

        return (root,query,criteriaBuilder)-> {
            if(name == null || name.isBlank()){
                return null;
            }
            return criteriaBuilder.like(
                    root.get("name"),
                    "%" + name + "%"
            );
        };

    }

    public static Specification<User> hasEmail(String email) {

        return (root, query, criteriaBuilder) -> {
            if (email == null || email.isBlank()) {
                return null;
            }
            return criteriaBuilder.like(
                    root.get("email"),
                    "%" + email + "%"
            );
        };
    };
}
