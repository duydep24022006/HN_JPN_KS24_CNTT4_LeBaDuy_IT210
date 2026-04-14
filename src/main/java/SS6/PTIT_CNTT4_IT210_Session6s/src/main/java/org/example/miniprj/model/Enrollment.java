package org.example.miniprj.model;
public class Enrollment {
    private int id;
    private int courseId;
    private String studentName;
    private String status;

    public Enrollment() {
    }

    public Enrollment(int id, int courseId, String studentName, String status) {
        this.id = id;
        this.courseId = courseId;
        this.studentName = studentName;
        this.status = status;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getCourseId() { return courseId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Enrollment{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", studentName='" + studentName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}