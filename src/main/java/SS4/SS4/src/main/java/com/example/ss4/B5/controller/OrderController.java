package com.example.ss4.B5.controller;

import com.example.ss4.B5.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bai5/orders")
public class OrderController {
    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    // Route xem đơn hàng
    @GetMapping("/{id}")
    public String getOrder(@PathVariable("id") int id) {
        return service.getOrder(id);
    }

    // Route tạo đơn hàng
    @PostMapping("/{id}")
    public String createOrder(@PathVariable("id") int id, @RequestBody String order) {
        return service.createOrder(id, order);
    }

    // Route hủy đơn hàng
    @DeleteMapping("/{id}")
    public String cancelOrder(@PathVariable("id") int id) {
        return service.cancelOrder(id);
    }

    // Xử lý ngoại lệ: ID không phải số
    @ExceptionHandler(NumberFormatException.class)
    public String handleNumberFormatException() {
        return "ID đơn hàng phải là một số";
    }

    // Xử lý ngoại lệ chung
    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgumentException(IllegalArgumentException ex) {
        return ex.getMessage();
    }
}
