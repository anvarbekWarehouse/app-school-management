package uz.hamkorbank.appschoolmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarkCreateDto {
    private Integer score;

    private LocalDateTime givenDateTime;

    private Long studentId;

    private Long lessonId;
}
