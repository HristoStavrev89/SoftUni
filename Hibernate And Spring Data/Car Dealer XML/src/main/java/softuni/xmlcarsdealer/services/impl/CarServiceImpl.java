package softuni.xmlcarsdealer.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.xmlcarsdealer.domain.dto.seedDtos.carSeedDtos.CarSeedDto;
import softuni.xmlcarsdealer.domain.dto.xmlDtos.carPartXmlDtos.CarPartRootViewDto;
import softuni.xmlcarsdealer.domain.dto.xmlDtos.carPartXmlDtos.CarPartRootViewDtoWrapp;
import softuni.xmlcarsdealer.domain.dto.xmlDtos.carPartXmlDtos.PartRootViewDto;
import softuni.xmlcarsdealer.domain.dto.xmlDtos.carPartXmlDtos.PartViewDto;
import softuni.xmlcarsdealer.domain.dto.xmlDtos.carXmlDtos.CarRootViewDto;
import softuni.xmlcarsdealer.domain.dto.xmlDtos.carXmlDtos.CarViewDto;
import softuni.xmlcarsdealer.domain.entities.Car;
import softuni.xmlcarsdealer.repositories.CarRepository;
import softuni.xmlcarsdealer.services.CarService;
import softuni.xmlcarsdealer.services.PartService;
import softuni.xmlcarsdealer.utils.ValidationUtil;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@Transactional
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final PartService partService;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Random random;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, PartService partService, ModelMapper modelMapper, ValidationUtil validationUtil, Random random) {
        this.carRepository = carRepository;
        this.partService = partService;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.random = random;
    }

    @Override
    public void seedCars(List<CarSeedDto> carSeedDtos) {
        for (CarSeedDto carSeedDto : carSeedDtos) {
            if (this.validationUtil.isValid(carSeedDto)) {

                if (this.carRepository.findByMakeAndModelAndTravelledDistance(carSeedDto.getMake(), carSeedDto.getModel(), carSeedDto.getTravelledDistance()) == null) {

                    Car car = this.modelMapper.map(carSeedDto, Car.class);
                    car.setParts(this.partService.getListWithRandomParts());

                    this.carRepository.saveAndFlush(car);
                } else {
                    System.out.println(String.format("%s %s %d already exists in the data-base."
                            , carSeedDto.getMake()
                            , carSeedDto.getModel()
                            , carSeedDto.getTravelledDistance()));
                }


            } else {
                this.validationUtil.getViolations(carSeedDto)
                        .stream()
                        .map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);
            }
        }


    }

    @Override
    public Car getRandomCar() {
        long carId = this.random.nextInt((int) this.carRepository.count()) + 1;

        return this.carRepository.findById(carId).orElse(null);


    }

    @Override
    public CarRootViewDto getAllCarsByMake() {

        CarRootViewDto carRootViewDto = new CarRootViewDto();

        //Adding hardcore value because the condition from the exercise
        String model = "Toyota";
        List<CarViewDto> carViewDtos = new ArrayList<>();

        System.out.println();
         this.carRepository.findAll()
                .stream()
                .filter(c -> c.getMake().equals(model))
                .sorted((a, b) -> {
                    int sort = a.getModel().compareTo(b.getModel());
                    if (sort == 0) {
                        sort = Long.compare(b.getTravelledDistance(), a.getTravelledDistance());
                    }
                    return sort;
                })
                 .forEach(car -> {
                     CarViewDto carViewDto = this.modelMapper.map(car, CarViewDto.class);
                     carViewDtos.add(carViewDto);
                 });

         carRootViewDto.setCars(carViewDtos);

        return carRootViewDto;
    }

    @Override
    public CarPartRootViewDtoWrapp getAllCarsWithTheirParts() {
        CarPartRootViewDtoWrapp carPartRootViewDtoWrapp = new CarPartRootViewDtoWrapp();

        List<CarPartRootViewDto> carPartRootViewDtoList = new ArrayList<>();

        List<Car> carList = this.carRepository.findAll();
        for (Car car : carList) {

            //Getting the parts to dto
            PartRootViewDto partRootViewDto = new PartRootViewDto();
            car.getParts()
                    .forEach(part -> {
                        PartViewDto partViewDto = this.modelMapper.map(part, PartViewDto.class);
                        partRootViewDto.getParts().add(partViewDto);
                    });
            CarPartRootViewDto carPartRootViewDto = this.modelMapper.map(car, CarPartRootViewDto.class);
            carPartRootViewDto.setPartRootViewDto(partRootViewDto);
            carPartRootViewDtoList.add(carPartRootViewDto);
        }
        carPartRootViewDtoWrapp.setCars(carPartRootViewDtoList);


        return carPartRootViewDtoWrapp;
    }
}
