package uz.hamkorbank.appschoolmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LessonsForMarkResponseDto {

    private Long lessonId;
    private String lessonName;

    private String subjectName;

    private Long teacherId;

    private String teacherName;
}
