package com.example.ss3.repository;

import com.example.ss3.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    private List<Student> students = new ArrayList<>();

    public StudentRepository() {
        // khởi tạo dữ liệu mẫu (thành viên nhóm)
        students.add(new Student(1, "SV001", "Nguyen Van A", "CNTT", 2022, 3.5, "Đang học"));
        students.add(new Student(2, "SV002", "Tran Thi B", "CNTT", 2021, 2.8, "Bảo lưu"));
        students.add(new Student(3, "SV003", "Le Van C", "Kinh tế", 2020, 3.9, "Tốt nghiệp"));
        students.add(new Student(4, "SV004", "Pham D", "CNTT", 2023, 3.2, "Đang học"));
    }

    public List<Student> findAll() {
        return students;
    }
}
