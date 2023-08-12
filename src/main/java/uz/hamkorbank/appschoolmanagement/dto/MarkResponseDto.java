package uz.hamkorbank.appschoolmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class MarkResponseDto {
    private Long id;

    private Integer score;
    private LocalDateTime givenDateTime;

    private UserForMarkResponseDto students;

    private LessonsForMarkResponseDto lessons;
}
