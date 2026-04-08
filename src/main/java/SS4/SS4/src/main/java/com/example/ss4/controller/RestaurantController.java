package com.example.ss4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class RestaurantController {
    @GetMapping("/bai3/orders/{id}")
    @ResponseBody
    public String getOrderById(@PathVariable("id") int id) {
        System.out.println("getOrderById " + id); // vẫn in ra console
        return "Chi tiết đơn hàng số " + id;      // trả về cho client
    }


    @GetMapping("/bai4/orders/{id}")
    public String getOrderById2(@PathVariable("id") int id , Model model){
        model.addAttribute("restauId",id);
        return "restaurant";
    }

}
