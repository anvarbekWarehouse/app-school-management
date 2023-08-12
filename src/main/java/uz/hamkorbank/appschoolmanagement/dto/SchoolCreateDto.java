package uz.hamkorbank.appschoolmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SchoolCreateDto {
    private String name;

    private Long addressId;
}
