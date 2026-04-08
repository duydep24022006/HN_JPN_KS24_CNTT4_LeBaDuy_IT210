package com.example.ss4.B5.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class OrderRepository {
    private final Map<Integer,String> orders = new HashMap<>();
    public String findById(int id) {
        return orders.get(id);
    }
    public void save(int id, String order) {
        orders.put(id, order);
    }
    public void delete(int id) {
        orders.remove(id);
    }
}
