package com.example.miniproject.dto;

import com.example.miniproject.modal.priority;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class TaskItiemDto {
    @NotBlank(message = "Không đc để trống Id!")
    private String id;
    @NotBlank(message = "Không đc để trống Title!")
    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Không được bỏ trống Deadline")
    @Future(message = "Thời gian chỉ đc ở tương lai")
    private LocalDate deadline;
    @NotNull(message = "Không đc bỏ trống Priority")
    private priority priority;

    public TaskItiemDto(String id, String title, LocalDate deadline, priority priority) {
        this.id = id;
        this.title = title;
        this.deadline = deadline;
        this.priority = priority;
    }

    public TaskItiemDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public priority getPriority() {
        return priority;
    }

    public void setPriority(priority priority) {
        this.priority = priority;
    }
}
