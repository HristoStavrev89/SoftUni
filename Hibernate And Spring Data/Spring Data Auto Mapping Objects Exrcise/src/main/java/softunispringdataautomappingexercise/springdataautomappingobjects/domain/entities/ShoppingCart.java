package softunispringdataautomappingexercise.springdataautomappingobjects.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softunispringdataautomappingexercise.springdataautomappingobjects.domain.dtos.game.GameAddDto;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "shopping_cart")
public class ShoppingCart extends BaseEntity{

    //todo
    @ManyToMany(mappedBy = "shoppingCart", targetEntity = Game.class, fetch = FetchType.EAGER)
    private Set<Game> title;

}
