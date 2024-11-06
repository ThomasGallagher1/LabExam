package ie.atu.labexam;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Pattern(regexp = "[A-Z0-9999]+", message = "Invalid format of EmployeeCode")
    private String employeeCode;
    @NotBlank(message = "You must enter a name")
    private String name;
    @Email(message = "You must enter a valid email")
    private String email;
    @NotBlank(message = "You must enter a valid position")
    private String position;
    @Min(value = 1, message = "Must be positive")
    private int salary;
    @PastOrPresent(message = "Must be an employee at this given time")
    private Date dateOfJoining;
}
