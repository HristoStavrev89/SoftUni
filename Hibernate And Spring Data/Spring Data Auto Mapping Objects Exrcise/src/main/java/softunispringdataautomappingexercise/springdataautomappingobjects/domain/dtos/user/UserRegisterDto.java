package softunispringdataautomappingexercise.springdataautomappingobjects.domain.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterDto {

    @Pattern(regexp = "[A-Za-z0-9]+@[A-Za-z0-9]+\\.[a-z]+", message = "Ë-mail is not valid.")
    private String email;

    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$", message = "The password is not valid.")
    private String password;
    @NotNull(message = "Full name must not be null.")
    private String fullName;

}
