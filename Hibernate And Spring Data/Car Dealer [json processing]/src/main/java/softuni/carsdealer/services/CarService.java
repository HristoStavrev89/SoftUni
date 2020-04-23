package softuni.carsdealer.services;

import softuni.carsdealer.domain.dtos.seedDtos.CarDtoSeed;
import softuni.carsdealer.domain.dtos.viewDtos.carsFromMakeToyota.CarToyotaDtoView;
import softuni.carsdealer.domain.dtos.viewDtos.carsWithTheirParts.CarPartDtoView;
import softuni.carsdealer.domain.entities.Car;

import java.util.List;

public interface CarService {


    void seedCar(CarDtoSeed[] carDtoSeeds);

    Car getRandomCar();

    List<CarToyotaDtoView> getAllCarsMadeFromToyota();

    List<CarPartDtoView> getCarsAndTheirParts();
}
