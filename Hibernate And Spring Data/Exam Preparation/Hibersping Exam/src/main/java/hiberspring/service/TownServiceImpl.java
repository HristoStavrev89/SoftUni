package hiberspring.service;

import com.google.gson.Gson;
import hiberspring.common.ConstantPath;
import hiberspring.common.Constants;
import hiberspring.domain.dtos.townDtos.townSeedDtos.TownSeedDto;
import hiberspring.domain.entities.Town;
import hiberspring.repository.TownRepository;
import hiberspring.util.FileUtil;
import hiberspring.util.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;

import static hiberspring.common.Constants.SUCCESSFUL_IMPORT_TOWN;

@Service
@Transactional
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final FileUtil fileUtil;

    @Autowired
    public TownServiceImpl(TownRepository townRepository, Gson gson, ModelMapper modelMapper, ValidatorUtil validatorUtil, FileUtil fileUtil) {
        this.townRepository = townRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.fileUtil = fileUtil;
    }


    @Override
    public Boolean townsAreImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsJsonFile() throws IOException {
        return this.fileUtil.readFile(ConstantPath.TOWN_PATH_LOCATION);
    }

    @Override
    public String importTowns(String townsFileContent) throws IOException {
        StringBuilder sb = new StringBuilder();

        TownSeedDto[] townRootSeedDtos = this.gson.fromJson(readTownsJsonFile(), TownSeedDto[].class);

        for (TownSeedDto townRootSeedDto : townRootSeedDtos) {
            if (this.validatorUtil.isValid(townRootSeedDto)) {

                if (this.townRepository.findByNameAndPopulation(townRootSeedDto.getName(), townRootSeedDto.getPopulation()) == null) {

                    Town town = this.modelMapper.map(townRootSeedDto, Town.class);

                    this.townRepository.saveAndFlush(town);

                    sb.append(String.format(SUCCESSFUL_IMPORT_TOWN, town.getName())).append(System.lineSeparator());

                } else {
                    sb.append(Constants.ALREADY_IN_THE_DATABASE).append(System.lineSeparator());
                }
            } else {
                sb.append(Constants.INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    @Override
    public Town getTownByNameAndPopulation(String name, int population) {
        return this.townRepository.findByNameAndPopulation(name, population);
    }

    @Override
    public Town getTownByName(String name) {
        return this.townRepository.findByName(name);
    }
}
