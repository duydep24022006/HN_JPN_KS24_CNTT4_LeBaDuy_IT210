package com.example.ss3.controller.new_way;

import com.example.ss3.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class EmployeeController {
    @GetMapping({"/","employee"})
    public String employee(Model model)
    {
        List<Employee> employees;
        employees = new ArrayList<>(
                Arrays.asList(
                        new Employee(1, "Nguyen Van A", "IT", 15000.0),
                        new Employee(2, "Tran Thi B", "HR", 1200.0),
                        new Employee(3, "Le Van C", "Finance", 8000.0),
                        new Employee(4, "Pham Thi D", "Marketing", 13000.0),
                        new Employee(5, "Hoang Van E", "Sales", 2000.0)
                )

        );
        model.addAttribute("employees", employees);
        return "views1/employee-list";
    }
}
