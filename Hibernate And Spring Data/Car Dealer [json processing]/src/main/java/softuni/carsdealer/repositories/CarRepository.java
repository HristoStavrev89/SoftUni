package softuni.carsdealer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.carsdealer.domain.entities.Car;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {


    Car findByModelAndTravelledDistance(String model, Long distance);

//    @Query("SELECT c.id,c.make,c.model,c.travelledDistance FROM Car As c WHERE c.make = 'Toyota' ORDER BY c.model, c.travelledDistance DESC")
//    List<Car> getAllCarsMadeFromToyota();

    List<Car> findAllByMakeOrderByModel(String make);

}
