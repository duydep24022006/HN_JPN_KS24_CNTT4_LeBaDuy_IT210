package org.example.miniprj.service;

import org.example.miniprj.dao.CourseDao;
import org.example.miniprj.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    private final CourseDao courseDao;

    public CourseService(CourseDao courseDao) {
        this.courseDao = courseDao;
    }
    // lay tat ca khoa hoc
    public List<Course> getAllCourse(){
        return courseDao.findAll();
    }

    public List<Course> fillterCourses(String level, Double maxFee){
        return courseDao.findAll().stream()
                .filter(c -> level == null|| level.isEmpty() || c.getLevel().trim().equalsIgnoreCase(level) )
                .filter(c -> maxFee == null || c.getPrice() <= maxFee)
                .collect(Collectors.toList());
    }

    // xoa khoa
    public void deleteCourse(int id){
        courseDao.findAll().removeIf(c -> c.getId() == id);
    }

}
