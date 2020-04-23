package softuni.exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.domain.entity.Player;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    Player findByFirstNameAndLastNameAndNumber(String firstName, String lastName, int number);

    @Query("SELECT p FROM Player AS p WHERE p.team.name = ?1 ORDER BY p.id")
    List<Player> findAllPlayersFromNorthHub(String teamName);

    List<Player> findAllBySalaryGreaterThanOrderBySalaryDesc(BigDecimal salary);


}
