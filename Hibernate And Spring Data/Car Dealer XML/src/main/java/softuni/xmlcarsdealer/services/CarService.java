package softuni.xmlcarsdealer.services;

import softuni.xmlcarsdealer.domain.dto.seedDtos.carSeedDtos.CarSeedDto;
import softuni.xmlcarsdealer.domain.dto.xmlDtos.carPartXmlDtos.CarPartRootViewDto;
import softuni.xmlcarsdealer.domain.dto.xmlDtos.carPartXmlDtos.CarPartRootViewDtoWrapp;
import softuni.xmlcarsdealer.domain.dto.xmlDtos.carXmlDtos.CarRootViewDto;
import softuni.xmlcarsdealer.domain.entities.Car;

import java.util.List;

public interface CarService {

    void seedCars(List<CarSeedDto> carSeedDtos);

    Car getRandomCar();

    CarRootViewDto getAllCarsByMake();

    CarPartRootViewDtoWrapp getAllCarsWithTheirParts();



}
