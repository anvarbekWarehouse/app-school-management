package uz.hamkorbank.appschoolmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.hamkorbank.appschoolmanagement.entity.enums.WeekDays;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TimeTableCreateDto {
    private Long lessonId;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    private WeekDays weekDays;


}
