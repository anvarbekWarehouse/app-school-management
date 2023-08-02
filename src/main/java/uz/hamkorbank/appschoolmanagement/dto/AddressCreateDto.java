package uz.hamkorbank.appschoolmanagement.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressCreateDto {

    @NotNull(message = "NOT NULL ADDRESS NAME{...........}")
    private String name;
}
