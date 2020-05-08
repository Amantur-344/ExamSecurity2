package kg.Exam2.service;

import kg.Exam2.entity.Student;

import javax.validation.constraints.Max;
import java.util.List;

public interface StudentService {
    Student create (Student student);
    Student deleteById (Long id);
    Student getById (Long id);

    List<Student> getByNameLike (String name);
}
