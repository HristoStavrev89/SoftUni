package softuni.xmlcarsdealer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.xmlcarsdealer.domain.entities.Car;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Car findByMakeAndModelAndTravelledDistance(String make, String model, Long distance);

    //Query 2 – Cars from Make Toyota
    @Query("SELECT c FROM Car AS c WHERE c.make = 'Toyota'")
    List<Car> findAllByMakeToyota(String make);


}
