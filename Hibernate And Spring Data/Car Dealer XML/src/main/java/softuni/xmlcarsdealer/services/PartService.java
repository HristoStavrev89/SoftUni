package softuni.xmlcarsdealer.services;

import softuni.xmlcarsdealer.domain.dto.seedDtos.partSeedDtos.PartSeedDto;
import softuni.xmlcarsdealer.domain.entities.Part;

import java.util.List;

public interface PartService {

    void seedParts(List<PartSeedDto> partSeedDtoList);

    Part getRandomPart();

    List<Part> getListWithRandomParts();

}
