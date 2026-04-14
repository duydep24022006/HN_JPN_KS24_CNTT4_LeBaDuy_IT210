package org.example.miniprj.controller;

import org.example.miniprj.model.Course;
import org.example.miniprj.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping

public class HomeController {

    private final CourseService courseService;

    public HomeController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/home")
    public String home(Model model){
         model.addAttribute("courses", courseService.getAllCourse());
        System.out.println(courseService.getAllCourse());
         return "home";
     }

    @GetMapping("/course/list")
    public String listCourse(
            @RequestParam(name = "level", required = false) String level,
            @RequestParam(name = "maxFee", required = false) Double maxFee,
            Model model
    ){
        model.addAttribute("courses", courseService.fillterCourses(level, maxFee));
        return "home";
    }
    @GetMapping("/course/detail/{id}")
    public String courseDetail(
            @PathVariable("id") int id,
            Model model
    ){
        Course course = courseService.getAllCourse().stream()
                .filter(c -> c.getId() ==  id )
                .findFirst()
                .orElse(null);
        if (course == null){
            model.addAttribute("error", "Khong tim thay khoa hoc");
            return "detail";
        }
        model.addAttribute("course", course);
        return "detail";
    }
    @GetMapping("/course/delete/{id}")
    public String courseDelete(
         @PathVariable("id") int id

    ){
        courseService.deleteCourse(id);
        return "redirect:/home";
    }
}
