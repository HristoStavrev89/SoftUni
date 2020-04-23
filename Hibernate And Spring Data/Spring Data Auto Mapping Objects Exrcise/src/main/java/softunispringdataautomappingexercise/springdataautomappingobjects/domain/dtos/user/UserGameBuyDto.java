package softunispringdataautomappingexercise.springdataautomappingobjects.domain.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softunispringdataautomappingexercise.springdataautomappingobjects.domain.entities.Game;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserGameBuyDto {

    private Set<String> games;

}
