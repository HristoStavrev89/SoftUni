package softuni.carsdealer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.carsdealer.domain.entities.Part;

import java.math.BigDecimal;

@Repository
public interface PartRepository extends JpaRepository<Part, Long> {

    Part findByNameAndPrice(String name, BigDecimal price);

    @Query("SELECT p FROM Part AS p WHERE p.id = ?1")
    Part getOnePart(long id);

}
