package com.example.miniproject.controller;

import com.example.miniproject.dto.TaskItiemDto;
import com.example.miniproject.modal.TaskItem;
import com.example.miniproject.modal.priority;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping
public class TaskController {
    List <TaskItem> taskItems=new ArrayList<TaskItem>(
            Arrays.asList(
                            new TaskItem("1", "Hoàn thành báo cáo tuần", LocalDate.of(2026, 4, 20), priority.HIGH),
                            new TaskItem("2", "Chuẩn bị slide thuyết trình", LocalDate.of(2026, 4, 25), priority.MEDIUM),
                            new TaskItem("3", "Đọc tài liệu Spring Boot", LocalDate.of(2026, 5, 1), priority.LOW)
            )
    );

    @GetMapping({"/","/task"})
    public String task(Model model){
        model.addAttribute("tasks",taskItems);
        return "task-list";
    }

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("task",new TaskItem());
        return "task-form";
    }
    @PostMapping("/form")
    public String addTask(@Valid @ModelAttribute("task") TaskItiemDto taskItemDto,
                          BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "task-form";
        }

        TaskItem newTask = new TaskItem(
                taskItemDto.getId(),
                taskItemDto.getTitle(),
                taskItemDto.getDeadline(),
                taskItemDto.getPriority()
        );
        taskItems.add(newTask);

        return "redirect:/task";
    }

}
