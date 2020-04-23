package softunispringdataautomappingexercise.springdataautomappingobjects.domain.dtos.game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameViewAllGamesDto {

    private String title;

    private BigDecimal price;
}
