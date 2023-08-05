package uz.hamkorbank.appschoolmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.hamkorbank.appschoolmanagement.entity.Role;
import uz.hamkorbank.appschoolmanagement.entity.School;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserResponseDto {
    private Long id;
    private String name;

    private String role;

    private String address;

    private SchoolResponseDto school;
}
