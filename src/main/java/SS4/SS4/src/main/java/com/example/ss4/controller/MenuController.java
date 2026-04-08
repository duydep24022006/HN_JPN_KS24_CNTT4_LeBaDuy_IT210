package com.example.ss4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MenuController {

    @GetMapping("/bai2/menu")
    @ResponseBody
    public String getMenu(
            @RequestParam(name = "category", required = false, defaultValue = "chay") String category
    ) {
        return "Thực đơn loại: " + category;
    }
}