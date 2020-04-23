package softuni.xmlcarsdealer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.xmlcarsdealer.domain.entities.Part;

import java.math.BigDecimal;

@Repository
public interface PartRepository extends JpaRepository<Part, Long> {

    Part findByNameAndPrice(String name, BigDecimal price);



}
