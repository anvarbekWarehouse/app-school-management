package uz.hamkorbank.appschoolmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.hamkorbank.appschoolmanagement.entity.Subject;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LessonsResponseDto {

    private Long id;

    private String name;

    private Integer maxStudent;

    private Subject subject;

    private UserResponseDto teacher;

    private List<UserResponseDto> students;
}
