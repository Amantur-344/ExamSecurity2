package kg.Exam2.controller;

import kg.Exam2.entity.Student;
import kg.Exam2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping
    Student create (@RequestBody Student student){
        return studentService.create(student);
    }
    @DeleteMapping
    Student deleteBuId (@RequestParam(name = "id") Long id){
        return studentService.deleteById(id);
    }
    @GetMapping
    Student getById (Long id){
        return studentService.getById(id);
    }
    @GetMapping
    List<Student> getByNameLike (String name){
        return studentService.getByNameLike(name);
    }
}
