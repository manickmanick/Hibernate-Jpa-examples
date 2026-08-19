package com.example.spring_security_learning.repository;

import com.example.spring_security_learning.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    @Query("""
        SELECT DISTINCT u
            FROM User u
                LEFT JOIN FETCH u.orders
    """)
    List<User> findAllWithOrders();


    @Query(
            value = """
                    SELECT * FROM users
                                        WHERE email = :email
                    """,
            nativeQuery = true
    )
    Optional<User> findByEmailNative(@Param("email") String email);
}
