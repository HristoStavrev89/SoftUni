package softuni.carsdealer.services.seviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.carsdealer.domain.dtos.seedDtos.CarDtoSeed;
import softuni.carsdealer.domain.dtos.viewDtos.carsFromMakeToyota.CarToyotaDtoView;
import softuni.carsdealer.domain.dtos.viewDtos.carsWithTheirParts.CarPartDtoView;
import softuni.carsdealer.domain.entities.Car;
import softuni.carsdealer.domain.entities.Part;
import softuni.carsdealer.repositories.CarRepository;
import softuni.carsdealer.services.CarService;
import softuni.carsdealer.services.PartService;
import softuni.carsdealer.utils.ValidationUtil;
import softuni.carsdealer.utils.dtoConverter.DtoConverter;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final PartService partService;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final DtoConverter dtoConverter;
    private final Random random;


    @Autowired
    public CarServiceImpl(CarRepository carRepository, PartService partService, ModelMapper modelMapper, ValidationUtil validationUtil, DtoConverter dtoConverter, Random random) {
        this.carRepository = carRepository;
        this.partService = partService;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.dtoConverter = dtoConverter;

        this.random = random;
    }


    @Override
    public void seedCar(CarDtoSeed[] carDtoSeeds) {
        for (CarDtoSeed dtoSeed : carDtoSeeds) {
            if (validationUtil.isValid(dtoSeed)) {
                Car car = this.dtoConverter.convert(dtoSeed, Car.class);

                //random part taking
                List<Part> parts = this.partService.getRandomParts();
                car.setParts(parts);
                if (this.carRepository.findByModelAndTravelledDistance(car.getModel(), car.getTravelledDistance()) == null) {
                    this.carRepository.saveAndFlush(car);
                }
            }
        }
    }

    @Override
    public Car getRandomCar() {
        long carId = this.random.nextInt((int) this.carRepository.count()) + 1;

        return this.carRepository.findById(carId).orElse(null);
    }

    @Override
    public List<CarToyotaDtoView> getAllCarsMadeFromToyota() {
        List<CarToyotaDtoView> toyotaCarsDtos = new ArrayList<>();



        this.carRepository.findAll()
                .stream()
                .filter(c -> c.getMake().equals("Toyota"))
                .sorted((a, b) -> {
                    int sort = a.getModel().compareTo(b.getModel());
                    if (a == b) {
                        sort = Double.compare(a.getTravelledDistance(), b.getTravelledDistance());
                    }
                    return sort;
                })
                .forEach(car -> {
                    CarToyotaDtoView carToyotaDtoView = this.modelMapper.map(car, CarToyotaDtoView.class);
                    toyotaCarsDtos.add(carToyotaDtoView);
                });


        return toyotaCarsDtos;
    }

    @Override
    public List<CarPartDtoView> getCarsAndTheirParts() {
        List<CarPartDtoView> carsAndParts = new ArrayList<>();

        this.carRepository.findAll()
                .forEach(car -> {
                    CarPartDtoView carPartDtoView = this.modelMapper.map(car, CarPartDtoView.class);
                    carsAndParts.add(carPartDtoView);
                });
        return carsAndParts;
    }

}
