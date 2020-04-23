package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.common.GlobalConstants;
import softuni.exam.common.GlobalPaths;
import softuni.exam.models.dtos.seedDtos.seedJsons.seedPassengers.PassengerSeedDto;
import softuni.exam.models.entities.Passenger;
import softuni.exam.models.entities.Town;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.service.PassengerService;
import softuni.exam.service.TownService;
import softuni.exam.util.FileUtil;
import softuni.exam.util.ValidationUtil;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class PassengerServiceImpl implements PassengerService {
    private final PassengerRepository passengerRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final FileUtil fileUtil;
    private final TownService townService;

    @Autowired
    public PassengerServiceImpl(PassengerRepository passengerRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil, FileUtil fileUtil, TownService townService) {
        this.passengerRepository = passengerRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.fileUtil = fileUtil;
        this.townService = townService;
    }


    @Override
    public boolean areImported() {
        return this.passengerRepository.count() > 0;
    }

    @Override
    public String readPassengersFileContent() throws IOException {
        return this.fileUtil.readFile(GlobalPaths.PASSENGERS_PATH);
    }

    @Override
    public String importPassengers() throws IOException {
        StringBuilder sb = new StringBuilder();


        PassengerSeedDto[] passengerSeedDtos = this.gson.fromJson(readPassengersFileContent(), PassengerSeedDto[].class);

        for (PassengerSeedDto passengerDto : passengerSeedDtos) {

            if (this.validationUtil.isValid(passengerDto)) {

                if (this.passengerRepository.findByEmail(passengerDto.getEmail()) == null) {



                    if (this.townService.getTownByName(passengerDto.getTown()) != null) {

                        Passenger passenger = this.modelMapper.map(passengerDto, Passenger.class);

                        Town town = this.townService.getTownByName(passengerDto.getTown());

                        passenger.setTown(town);

                        sb.append(String.format(GlobalConstants.SUCCESSFULLY_IMPORTED_PASSENGER, passenger.getLastName(), passenger.getEmail()))
                                .append(System.lineSeparator());

                        this.passengerRepository.saveAndFlush(passenger);

                    }


                }

            } else {
                sb.append(GlobalConstants.INVALID_PASSENGER)
                        .append(System.lineSeparator());
            }

        }




        return sb.toString();
    }

    @Override
    public Passenger getPassengerByEmail(String email) {

        return this.passengerRepository.findByEmail(email);
    }

    @Override
    public String getPassengersOrderByTicketsCountDescendingThenByEmail() {
        StringBuilder sb = new StringBuilder();

        List<Passenger> passengers = this.passengerRepository.findAllByTickets();

        passengers
                .forEach(p -> {
                    sb.append(String.format("Passenger - %s %s", p.getFirstName(), p.getLastName())).append(System.lineSeparator());
                    sb.append(String.format("    Email - %s", p.getEmail())).append(System.lineSeparator());
                    sb.append(String.format("    Phone: %s", p.getPhoneNumber())).append(System.lineSeparator());
                    sb.append(String.format("    Number of tickets - %d", p.getTickets().size())).append(System.lineSeparator());
                });

        return sb.toString();
    }
}
