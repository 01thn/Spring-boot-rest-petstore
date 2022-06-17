package com.thn.restpetstore.controller;

import com.thn.restpetstore.entity.Order;
import com.thn.restpetstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/store")
public class StoreController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<Order> save(@RequestBody Order order) {
        return new ResponseEntity<>(orderService.saveNewOrder(order), HttpStatus.CREATED);
    }

    @DeleteMapping("/order/{orderId}")
    public ResponseEntity<?> delete(@PathVariable Long orderId) {
        orderService.deleteOrderById(orderId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<Order> find(@PathVariable Long orderId) {
        Optional<Order> order = orderService.findOrderById(orderId);
        if (order.isPresent()) {
            return new ResponseEntity<>(order.get(), HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }
}
