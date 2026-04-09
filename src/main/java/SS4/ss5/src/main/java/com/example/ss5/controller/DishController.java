package com.example.ss5.controller;

import com.example.ss5.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DishController {
    @Autowired
    private DishService dishService;

    @GetMapping("/dish")
    public String getAllDishes(Model model) {
        model.addAttribute("dishes", dishService.findAll());
        return "dish/dish-list";
    }
}
