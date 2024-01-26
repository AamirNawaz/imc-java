package com.imcjava.repository;

import com.imcjava.models.Order;
import com.imcjava.models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findOrdersByCustomerId(User customerId);

    Optional<Order> findOrderByIdAndCustomerId(Long Id, User user);

    @Transactional
    void deleteOrderByIdAndCustomerId(Long id, User user);
}
