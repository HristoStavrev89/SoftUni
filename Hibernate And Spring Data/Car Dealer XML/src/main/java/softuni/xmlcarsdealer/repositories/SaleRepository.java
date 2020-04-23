package softuni.xmlcarsdealer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.xmlcarsdealer.domain.entities.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {



}
