package springdataautomappingobjects.demo.services.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class EmployeeViewDto {
    private String firstName;
    private double salary;
    private String cityName;
}
