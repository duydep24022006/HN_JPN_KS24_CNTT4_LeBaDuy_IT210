package com.example.ss2.controller.old_way;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/welcome")
    public String showWelcome(Model model) {
        model.addAttribute("staffName", "Nguyễn Văn An");
        model.addAttribute("department", "Phòng Kỹ thuật");
        return "welcome";   // ViewResolver phải ghép: /WEB-INF/views/welcome.jsp
    }
}

