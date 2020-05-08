package kg.Exam2.repository;

import kg.Exam2.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findAllByFullNameLike (String fullName);
}
