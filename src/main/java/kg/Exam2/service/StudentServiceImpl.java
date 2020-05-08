package kg.Exam2.service;

import kg.Exam2.entity.Student;
import kg.Exam2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student create(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student deleteById(Long id) {
        Student student = getById(id);
        if (student != null) {
            studentRepository.deleteById(id);
        }
        return student;
    }

    @Override
    public Student getById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Student> getByNameLike(String name) {
        return studentRepository.findAllByFullNameLike(name);
    }
}
