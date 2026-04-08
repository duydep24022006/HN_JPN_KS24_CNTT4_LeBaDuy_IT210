package com.example.ss4.B5.service;


import com.example.ss4.B5.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public String getOrder(int id) {
        String order = repository.findById(id);
        if (order == null) {
            throw new IllegalArgumentException("Không tìm thấy đơn hàng số " + id);
        }
        return order;
    }

    public String createOrder(int id, String order) {
        repository.save(id, order);
        return "Đã tạo đơn hàng số " + id;
    }

    public String cancelOrder(int id) {
        repository.delete(id);
        return "Đã hủy đơn hàng số " + id;
    }
}
