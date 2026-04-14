package org.example.miniprj.model;

import java.util.Date;

public class Course {
    private int id;
    private String code;
    private String name;
    private String level; // Beginner / Intermediate / Advanced
    private double price;
    private Date startDate;
    private String duration;
    private String teacher;
    private int studentCount;
    private boolean isFull;
    public Course() {
    }

    public Course(int id, String code, String name, String level, double price, Date startDate,
                  String duration, String teacher, int studentCount, boolean isFull) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.level = level;
        this.price = price;
        this.startDate = startDate;
        this.duration = duration;
        this.teacher = teacher;
        this.studentCount = studentCount;
        this.isFull = isFull;
    }

    // Getter & Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }

    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }

    public String getTeacher() { return teacher; }
    public void setTeacher(String teacher) { this.teacher = teacher; }

    public int getStudentCount() { return studentCount; }
    public void setStudentCount(int studentCount) { this.studentCount = studentCount; }

    public boolean isFull() { return isFull; }
    public void setFull(boolean full) { isFull = full; }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", level='" + level + '\'' +
                ", price=" + price +
                ", startDate=" + startDate +
                ", duration='" + duration + '\'' +
                ", teacher='" + teacher + '\'' +
                ", studentCount=" + studentCount +
                ", isFull=" + isFull +
                '}';
    }
}