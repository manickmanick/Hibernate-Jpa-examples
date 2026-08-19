package com.example.spring_security_learning.repository;

import com.example.spring_security_learning.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
