package softunispringdataautomappingexercise.springdataautomappingobjects.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softunispringdataautomappingexercise.springdataautomappingobjects.domain.entities.Game;
import softunispringdataautomappingexercise.springdataautomappingobjects.domain.entities.User;

import java.util.Set;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {


    Game findById(long id);

    Game findByTitle(String title);

    @Query("SELECT g FROM Game AS g")
    Set<Game> findAllGames();


    Set<Game> findAllByUser(User user);




}
