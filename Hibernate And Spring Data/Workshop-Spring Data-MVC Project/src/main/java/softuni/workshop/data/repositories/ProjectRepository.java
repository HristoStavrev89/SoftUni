package softuni.workshop.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.workshop.data.entities.Project;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {

    Project findByName(String name);

    List<Project> findByFinishedIsTrue();

}
