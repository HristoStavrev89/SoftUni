package softunispringdataautomappingexercise.springdataautomappingobjects.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softunispringdataautomappingexercise.springdataautomappingobjects.domain.entities.Game;
import softunispringdataautomappingexercise.springdataautomappingobjects.domain.entities.User;

import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);






}
