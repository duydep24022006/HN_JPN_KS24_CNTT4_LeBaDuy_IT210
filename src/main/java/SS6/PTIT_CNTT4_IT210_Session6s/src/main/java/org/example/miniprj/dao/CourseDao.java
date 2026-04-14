package org.example.miniprj.dao;

import org.example.miniprj.model.Course;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class CourseDao {
    public static List<Course> courses = new ArrayList<>(Arrays.asList(
            new Course(1, "ENG-B1", "Tiếng Anh Giao Tiếp Cơ Bản", "Beginner", 5000000,
                    new GregorianCalendar(2026, Calendar.APRIL, 15).getTime(), "8 tuần",
                    "Nguyễn Văn A", 10, true),

            new Course(2, "ENG-I1", "Tiếng Anh Trung Cấp 1", "Intermediate", 6000000,
                    new GregorianCalendar(2026, Calendar.MAY, 1).getTime(), "10 tuần",
                    "Trần Thị B", 15, false),

            new Course(3, "IELTS-5.5", "Luyện Thi IELTS 5.5", "Intermediate", 7500000,
                    new GregorianCalendar(2026, Calendar.MAY, 10).getTime(), "12 tuần",
                    "Lê Văn C", 20, false)
    ));


    // lay ve danh sach
    public  List<Course> findAll(){
        return  courses;

    }



}
