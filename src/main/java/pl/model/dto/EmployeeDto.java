package pl.model.dto;


import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class EmployeeDto {

    @NotBlank(message = "Insert your login")
    private String login;

    @Length(min = 6,message = "Your password requires at least 6 characters")
    private String password;
}
