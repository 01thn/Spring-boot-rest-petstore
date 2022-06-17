package com.thn.restpetstore.service;

import com.thn.restpetstore.entity.Order;
import com.thn.restpetstore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order saveNewOrder(Order order) {
        return orderRepository.save(order);
    }

    @Transactional
    public void deleteOrderById(Long id) {
        orderRepository.deleteOrderById(id);
    }

    public Optional<Order> findOrderById(Long orderId) {
        return orderRepository.findOrderById(orderId);
    }
}
