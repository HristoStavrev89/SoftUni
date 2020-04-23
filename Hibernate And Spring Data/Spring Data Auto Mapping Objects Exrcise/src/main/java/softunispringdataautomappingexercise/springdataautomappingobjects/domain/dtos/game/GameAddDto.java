package softunispringdataautomappingexercise.springdataautomappingobjects.domain.dtos.game;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameAddDto {

    @Pattern(regexp = "[A-Z].+[a-z0-9]+", message = "Incorrect valid title game title")
    private String title;

    @DecimalMin(value = "0", message = "Incorrect given price.")
    private BigDecimal price;

    @Min(value = 0, message = "Incorrect given size.")
    private double size;

    @Size(min = 11, max = 11, message = "Invalid given trailer.")
    private String trailer;

    @Pattern(regexp = "^https:\\/\\/.+|https:\\/\\/.+", message = "Incorrect given image.")
    private String image;

    @Size(min = 20, message = "The given description is not valid.")
    private String description;
    private LocalDate release_date;

}
