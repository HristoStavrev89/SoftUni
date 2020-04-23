package softunispringdataautomappingexercise.springdataautomappingobjects.domain.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softunispringdataautomappingexercise.springdataautomappingobjects.domain.entities.Role;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private String fullName;
    private String email;
    private String password;
    private Role role;

}
