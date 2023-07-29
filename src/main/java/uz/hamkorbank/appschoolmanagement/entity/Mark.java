package uz.hamkorbank.appschoolmanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "marks")
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 50, max = 100)
    private Integer score;   // min =50 max =  100

    private LocalDateTime givenDateTime;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private User student;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lessons lessons;
}
