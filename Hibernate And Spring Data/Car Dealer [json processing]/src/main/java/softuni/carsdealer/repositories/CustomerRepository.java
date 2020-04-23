package softuni.carsdealer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.carsdealer.domain.entities.Customer;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByNameAndBirthDate(String name, LocalDateTime birthDate);


    @Query("select c FROM Customer AS c ORDER BY c.birthDate")
    List<Customer> findAllOrderByBirthDate();

}
