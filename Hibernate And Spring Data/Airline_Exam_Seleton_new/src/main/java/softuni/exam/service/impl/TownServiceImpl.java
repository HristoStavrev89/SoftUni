package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.common.GlobalConstants;
import softuni.exam.common.GlobalPaths;
import softuni.exam.models.dtos.seedDtos.seedJsons.seedTown.SeedTownDto;
import softuni.exam.models.entities.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.FileUtil;
import softuni.exam.util.ValidationUtil;

import javax.transaction.Transactional;
import java.io.IOException;

@Service
@Transactional
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final FileUtil fileUtil;

    @Autowired
    public TownServiceImpl(TownRepository townRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil, FileUtil fileUtil) {
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.fileUtil = fileUtil;
    }


    @Override
    public boolean areImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return this.fileUtil.readFile(GlobalPaths.TOWNS_PATH);
    }

    @Override
    public String importTowns() throws IOException {
        StringBuilder sb = new StringBuilder();

        SeedTownDto[] seedTownDtos = this.gson.fromJson(readTownsFileContent(), SeedTownDto[].class);

        for (SeedTownDto townDto : seedTownDtos) {

            if (this.validationUtil.isValid(townDto)) {

                if (this.townRepository.findByName(townDto.getName()) == null) {

                    Town town = this.modelMapper.map(townDto, Town.class);

                    this.townRepository.saveAndFlush(town);

                    sb.append(String.format(GlobalConstants.SUCCESSFULLY_IMPORTED_TOWN, town.getName(), town.getPopulation()))
                            .append(System.lineSeparator());

                } else {
                    sb.append(GlobalConstants.ALREADY_IN_DB).append(System.lineSeparator());
                }

            } else {
                sb.append(GlobalConstants.INVALID_TOWN).append(System.lineSeparator());
            }

        }

        return sb.toString();
    }

    @Override
    public Town getTownByName(String name) {
        return this.townRepository.findByName(name);
    }
}
