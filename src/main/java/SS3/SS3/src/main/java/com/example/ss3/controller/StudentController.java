package com.example.ss3.controller;

import com.example.ss3.model.Student;
import com.example.ss3.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping({"/","/students"})
    public String list(@RequestParam(name="sortBy", required=false) String sortBy,
                       @RequestParam(name="search", required=false) String search,
                       @RequestParam(name="faculty", required=false) String faculty,
                       Model model) {
        List<Student> students = service.getAll(sortBy, search, faculty);
        model.addAttribute("students", students);
        model.addAttribute("search", search);
        model.addAttribute("faculty", faculty);
        return "students/list";
    }


    @GetMapping("/students/detail")
    public String detail(@RequestParam(name="id") int id, Model model) {
        Student s = service.getById(id);
        model.addAttribute("student", s);
        return "students/detail";
    }


    @GetMapping("/students/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("total", service.totalStudents());
        model.addAttribute("avgGpa", service.averageGpa());
        model.addAttribute("topStudent", service.topStudent());
        model.addAttribute("countHoc", service.countByStatus("Đang học"));
        model.addAttribute("countBaoLuu", service.countByStatus("Bảo lưu"));
        model.addAttribute("countTotNghiep", service.countByStatus("Tốt nghiệp"));
        return "students/dashboard";
    }
}