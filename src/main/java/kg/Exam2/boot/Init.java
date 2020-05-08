package kg.Exam2.boot;

import kg.Exam2.entity.Course;
import kg.Exam2.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Init implements CommandLineRunner {
    @Autowired
    private CourseService courseService;
    @Override
    public void run(String... args) throws Exception {
        courseService.create(new Course("Java"));
        courseService.create(new Course("JavaScript"));
        courseService.create(new Course("Python"));
        courseService.create(new Course("C++"));
    }
}
