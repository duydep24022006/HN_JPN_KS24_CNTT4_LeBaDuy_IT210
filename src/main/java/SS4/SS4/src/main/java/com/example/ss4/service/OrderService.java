package com.example.ss4.service;

import com.example.ss4.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    public OrderService() {
        this.orderRepository = new OrderRepository();
    }
    public String getAllOrders() {
        return orderRepository.getAllOrders();
    }

    public String getOrderById(Long id) {

        return orderRepository.getOrderById(id);

    }

}


