package com.thn.restpetstore.repository;

import com.thn.restpetstore.entity.Order;
import com.thn.restpetstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    void deleteOrderById(Long id);

    Optional<Order> findOrderById(Long orderId);
}
