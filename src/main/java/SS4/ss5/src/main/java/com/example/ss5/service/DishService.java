package com.example.ss5.service;

import com.example.ss5.modal.Dish;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishService {


    private final List<Dish> dishes = new ArrayList<>();
    // Lấy tất cả món ăn
    public DishService() {
        // dữ liệu mẫu
        dishes.add(new Dish(1, "Phở bò", 45000.0, true));
        dishes.add(new Dish(2, "Bún chả", 40000.0, true));
        dishes.add(new Dish(3, "Cơm tấm", 35000.0, false));
        dishes.add(new Dish(4, "Gỏi cuốn", 30000.0, true));
    }
    public List<Dish> findAll() {
        return new ArrayList<>(dishes);
    }
}
