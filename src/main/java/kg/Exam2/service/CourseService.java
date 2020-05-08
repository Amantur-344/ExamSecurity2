package kg.Exam2.service;

import kg.Exam2.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAll();
    Course create (Course course);
}
