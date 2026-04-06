package com.example.ss2.model;

public class Student {
    private String fullName;
    private double score;
    public Student(String name, double score) {
        this.fullName = name;
        this.score = score;
    }
    public String getFullName() {
        return fullName;
    }
    public double getScore() {return score;}
    public void setName(String name) {this.fullName = name;}
    public void setScore(double score) {this.score = score;}

    @Override
    public String toString() {
        return "Student{" +
                "name='" + fullName + '\'' +
                ", score=" + score +
                '}';
    }
}
