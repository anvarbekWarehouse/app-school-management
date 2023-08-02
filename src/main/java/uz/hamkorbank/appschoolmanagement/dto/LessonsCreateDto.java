package uz.hamkorbank.appschoolmanagement.dto;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.hamkorbank.appschoolmanagement.entity.Subject;
import uz.hamkorbank.appschoolmanagement.entity.User;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LessonsCreateDto {
    private String name;

    private Integer maxStudent;

    private Long subjectId;

    private Long teacherId;
    /**
     * One Lessons Many Students
     */
    private Set<Long> studentIds;
}
