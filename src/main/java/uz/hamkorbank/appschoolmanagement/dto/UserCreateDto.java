package uz.hamkorbank.appschoolmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserCreateDto {

    private String name;
    private String email;

    private Long roleId;
    private Long addressId;

    private Long schoolId;
}
