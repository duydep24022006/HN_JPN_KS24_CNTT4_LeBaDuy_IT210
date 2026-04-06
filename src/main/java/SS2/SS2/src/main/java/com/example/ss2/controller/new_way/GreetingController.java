package com.example.ss2.controller.new_way;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller("/home")
public class GreetingController {
    @GetMapping
    public String greeting(HttpServletRequest request)
    {
        List<String> names = new ArrayList<>(
                Arrays.asList(
                        "Vũ Việt Tiến",
                        "Nguyễn Doanh Tuấn",
                        "Hoàng Thái Minh",
                        "Phạm Thị Hồng Nhung"
                )
        );
        request.setAttribute("names", names);
        request.setAttribute("money",1200000);
        return "students";
    }
    @GetMapping("/add")
    public String formAdd() {
        return "form_add";
    }

}
