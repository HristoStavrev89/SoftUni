package softuni.carsdealer.services;

import softuni.carsdealer.domain.dtos.seedDtos.PartDtoSeed;
import softuni.carsdealer.domain.entities.Part;

import java.util.List;

public interface PartService {

    void seedPart(PartDtoSeed[] partDtoSeeds);

    List<Part> getRandomParts();

}
