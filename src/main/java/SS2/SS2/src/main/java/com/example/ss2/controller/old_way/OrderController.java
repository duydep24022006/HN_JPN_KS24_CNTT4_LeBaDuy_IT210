package com.example.ss2.controller.old_way;

import com.example.ss2.model.Order;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private ServletContext application; // inject sẵn từ container

    @GetMapping("/orders")
    public String orders(HttpSession session, Model model) {
        if (session.getAttribute("loggedUser") == null) {
            return "redirect:/login";
        }

        // danh sách đơn hàng giả
        List<Order> orders = List.of(
                new Order("DH001", "Laptop", 15000000, new Date()),
                new Order("DH002", "Điện thoại", 8000000, new Date()),
                new Order("DH003", "Tai nghe", 1200000, new Date())
        );
        model.addAttribute("orders", orders);

        // cập nhật bộ đếm toàn cục (Application scope)
        synchronized (application) {
            Integer count = (Integer) application.getAttribute("totalViewCount");
            if (count == null) count = 0;
            count++;
            application.setAttribute("totalViewCount", count);
        }

        return "orders";
    }
}
