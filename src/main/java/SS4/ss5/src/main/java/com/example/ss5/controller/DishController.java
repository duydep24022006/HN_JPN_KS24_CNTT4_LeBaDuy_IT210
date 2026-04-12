package com.example.ss5.controller;

import com.example.ss5.modal.Dish;
import com.example.ss5.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DishController {
    @Autowired
    private DishService dishService;

    @GetMapping("/dish")
    public String getAllDishes(Model model) {
        model.addAttribute("dishes", dishService.findAll());
        return "dish/dish-list";
    }

    @GetMapping("edit-dish/{id}")
    public String getEditDish(@PathVariable("id") int id, Model model) {
        Dish dish = dishService.findById(id);
        if (dish == null) {
            model.addAttribute("errorMessage", "Không tìm thấy món ăn yêu cầu!");
            return "redirect:/dish/dish-list";
        }
        model.addAttribute("dish", dish);
        return "/dish/edit-dish";
    }

    @PostMapping("/update")
    public String updateDish(@ModelAttribute Dish dish) {
        Dish updated = dishService.updateDish(dish);
        if (updated == null) {
            return "redirect:/dish/dish-list?error=notfound";
        }
        return "redirect:/dish";
    }

}
