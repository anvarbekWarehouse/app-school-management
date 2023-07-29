package uz.hamkorbank.appschoolmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.hamkorbank.appschoolmanagement.entity.enums.WeekDays;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "time_tables")
public class TimeTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lessons lessons;

    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    @Enumerated(EnumType.STRING)
    private WeekDays weekDay;

}
