package org.example.miniprj.model;
public class CourseDetail {
    private int id;
    private int courseId; // FK -> Course
    private String description;
    public CourseDetail() {
    }

    public CourseDetail(int id, int courseId, String description) {
        this.id = id;
        this.courseId = courseId;
        this.description = description;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getCourseId() { return courseId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return "CourseDetail{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", description='" + description + '\'' +
                '}';
    }
}