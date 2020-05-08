package kg.Exam2.service;

import kg.Exam2.entity.Course;
import kg.Exam2.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Override
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course create(Course course) {
        return courseRepository.save(course);
    }
}
