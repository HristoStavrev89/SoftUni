package softunispringdataautomappingexercise.springdataautomappingobjects.domain.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "games")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Game extends BaseEntity{

    private String description;
    private String image;
    private BigDecimal price;
    private LocalDate release_date;
    private Double size;
    private String title;
    private String trailer;


    @ManyToMany(mappedBy = "games", targetEntity = User.class, fetch = FetchType.EAGER)
    private Set<User> user;

    @ManyToMany(mappedBy = "games", targetEntity = Order.class, fetch = FetchType.EAGER)
    private Set<Order> orders;
}
