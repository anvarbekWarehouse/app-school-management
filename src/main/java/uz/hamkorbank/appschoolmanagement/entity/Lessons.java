package uz.hamkorbank.appschoolmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "lessonses")
public class Lessons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer maxStudent;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private User teacher;
    /**
     * One Lessons Many Students
     */
    @OneToMany
    private List<User> students;

    public Lessons(String name, Integer maxStudent, Subject subject, User teacher) {
        this.name = name;
        this.maxStudent = maxStudent;
        this.subject = subject;
        this.teacher = teacher;
    }
}
