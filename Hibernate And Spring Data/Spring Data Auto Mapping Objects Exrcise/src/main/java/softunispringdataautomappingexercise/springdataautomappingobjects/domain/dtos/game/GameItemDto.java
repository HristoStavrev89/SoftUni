package softunispringdataautomappingexercise.springdataautomappingobjects.domain.dtos.game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameItemDto {

    @Pattern(regexp = "[A-Z].+[a-z0-9]+", message = "Incorrect valid game title")
    private String title;

}
