package softunispringdataautomappingexercise.springdataautomappingobjects.domain.dtos.game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameDetailView {

    private String title;
    private BigDecimal price;
    private String description;
    private LocalDate release_date;

}
