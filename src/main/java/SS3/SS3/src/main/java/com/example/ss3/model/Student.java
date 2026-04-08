package com.example.ss3.model;

public class Student {
    private int id;
    private String studentCode;
    private String fullName;
    private String faculty;
    private int enrollmentYear;
    private double gpa;
    private String status; // "Đang học", "Bảo lưu", "Tốt nghiệp"

    public Student(int id, String studentCode, String fullName,
                   String faculty, int enrollmentYear, double gpa, String status) {
        this.id = id;
        this.studentCode = studentCode;
        this.fullName = fullName;
        this.faculty = faculty;
        this.enrollmentYear = enrollmentYear;
        this.gpa = gpa;
        this.status = status;
    }

    // getters
    public int getId() { return id; }
    public String getStudentCode() { return studentCode; }
    public String getFullName() { return fullName; }
    public String getFaculty() { return faculty; }
    public int getEnrollmentYear() { return enrollmentYear; }
    public double getGpa() { return gpa; }
    public String getStatus() { return status; }
}
