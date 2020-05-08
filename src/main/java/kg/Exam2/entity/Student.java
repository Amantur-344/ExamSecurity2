package kg.Exam2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full_name",nullable = false)
    private String fullName;
    @ManyToOne
    @JoinColumn(name = "course_id",nullable = false)
    private Course course;
    @Column(name = "date_time", nullable = false)
    private LocalDateTime localDateTime;
    @Column(name = "contract_amount" , nullable = false)
    private Integer contractAmount;
}
