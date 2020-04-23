package softunispringdataautomappingexercise.springdataautomappingobjects.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order extends BaseEntity {


    @ManyToOne
    @JoinColumn(name = "buyer_id", referencedColumnName = "id")
    private User user;

    @ManyToMany
    @JoinTable(name = "orders_ordered_games",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ordered_game_id", referencedColumnName = "id"))
    private Set<Game> games;


}
