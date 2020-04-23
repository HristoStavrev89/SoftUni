package softuni.xmlcarsdealer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.xmlcarsdealer.domain.entities.Customer;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByNameAndBirthDate(String name, LocalDateTime birthDate);

    //Query 1 - Ordered Customers
    @Query("SELECT c FROM Customer AS c ORDER BY c.birthDate, c.youngDriver")
    List<Customer> findCustomersOrderedByBirthDateAndYoungDriver();

}
