package com.example.ss3.service;

import com.example.ss3.model.Student;
import com.example.ss3.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public List<Student> getAll(String sortBy, String search, String faculty) {
        List<Student> list = repo.findAll();

        // lọc
        if (search != null && !search.isEmpty()) {
            list = list.stream()
                    .filter(s -> s.getFullName().toLowerCase().contains(search.toLowerCase()))
                    .collect(Collectors.toList());
        }
        if (faculty != null && !faculty.isEmpty()) {
            list = list.stream()
                    .filter(s -> s.getFaculty().equalsIgnoreCase(faculty))
                    .collect(Collectors.toList());
        }

        // sắp xếp
        if ("name".equals(sortBy)) {
            list = list.stream()
                    .sorted(Comparator.comparing(Student::getFullName))
                    .collect(Collectors.toList());
        } else if ("gpa".equals(sortBy)) {
            list = list.stream()
                    .sorted(Comparator.comparing(Student::getGpa).reversed())
                    .collect(Collectors.toList());
        }

        return list;
    }

    public Student getById(int id) {
        return repo.findAll().stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Dashboard
    public int totalStudents() {
        return repo.findAll().size();
    }

    public double averageGpa() {
        return repo.findAll().stream()
                .mapToDouble(Student::getGpa)
                .average().orElse(0);
    }

    public Student topStudent() {
        return repo.findAll().stream()
                .max(Comparator.comparing(Student::getGpa))
                .orElse(null);
    }

    public long countByStatus(String status) {
        return repo.findAll().stream()
                .filter(s -> s.getStatus().equals(status))
                .count();
    }
}