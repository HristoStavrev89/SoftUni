package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.common.GlobalConstants;
import softuni.exam.common.GlobalPath;
import softuni.exam.models.dtos.seedDtos.carsSeedDtos.CarSeedDto;
import softuni.exam.models.entities.Car;
import softuni.exam.repository.CarRepository;
import softuni.exam.service.CarService;
import softuni.exam.util.FileUtil;
import softuni.exam.util.ValidationUtil;

import javax.transaction.Transactional;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@Transactional
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final FileUtil fileUtil;

    public CarServiceImpl(CarRepository carRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil, FileUtil fileUtil) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.fileUtil = fileUtil;
    }


    @Override
    public boolean areImported() {
        return this.carRepository.count() > 0;
    }

    @Override
    public String readCarsFileContent() throws IOException {
        return this.fileUtil.readFile(GlobalPath.CARS_PATH);
    }

    @Override
    public String importCars() throws IOException {
        StringBuilder sb = new StringBuilder();

        CarSeedDto[] carSeedDtos = this.gson.fromJson(readCarsFileContent(), CarSeedDto[].class);

        for (CarSeedDto carSeedDto : carSeedDtos) {
            if (this.validationUtil.isValid(carSeedDto)) {

                if (this.carRepository.findByMakeAndModelAndKilometers(carSeedDto.getMake(), carSeedDto.getModel(), carSeedDto.getKilometers()) == null) {

                    Car car = this.modelMapper.map(carSeedDto, Car.class);

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String dateDto = carSeedDto.getRegisteredOn();
                    LocalDate localDate = LocalDate.from(formatter.parse(dateDto));

                    car.setRegisteredOn(localDate);

                    sb.append(String.format(GlobalConstants.SUCCESSFULLY_IMPORTED_CAR, car.getMake(), car.getModel()))
                            .append(System.lineSeparator());

                    this.carRepository.saveAndFlush(car);

                } else {
                    sb.append(String.format(GlobalConstants.ALREADY_EXISTS_IN_DB, carSeedDto.getMake(), carSeedDto.getModel(), carSeedDto.getKilometers()))
                            .append(System.lineSeparator());
                }

            } else {
                sb.append(sb.append(GlobalConstants.INVALID_CAR)).append(System.lineSeparator());
            }
        }

        return sb.toString();
    }

    @Override
    public String getCarsOrderByPicturesCountThenByMake() {
        return null;
    }

    @Override
    public Car getCarById(int id) {
        return this.carRepository.getById(id);
    }
}
