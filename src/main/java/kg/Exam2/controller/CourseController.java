package kg.Exam2.controller;

import kg.Exam2.entity.Course;
import kg.Exam2.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @GetMapping
    List<Course> getAll(){
        return courseService.getAll();
    }
    @PostMapping
    Course create (@RequestBody Course course){
        return courseService.create(course);
    }
}
