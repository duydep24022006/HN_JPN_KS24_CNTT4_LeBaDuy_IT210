package com.example.ss2.controller.old_way;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {
        if(("admin".equals(username) && "admin123".equals(password)) ||
                ("staff".equals(username) && "staff123".equals(password))) {
            session.setAttribute("loggedUser", username);
            session.setAttribute("role", username.equals("admin") ? "Quản trị" : "Nhân viên");
            return "redirect:/orders";
        } else {
            // lỗi chỉ tồn tại trong request
            model.addAttribute("errorMessage", "Sai tài khoản hoặc mật khẩu!");
            return "login";
        }
    }
    @GetMapping("/login")
    public String loginPage() {
        return "login"; // trả về login.jsp
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}