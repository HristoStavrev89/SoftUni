package softuni.carsdealer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.carsdealer.domain.entities.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {



}
