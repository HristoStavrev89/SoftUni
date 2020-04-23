package hiberspring.service;

import com.google.gson.Gson;
import hiberspring.common.ConstantPath;
import hiberspring.common.Constants;
import hiberspring.domain.dtos.branchDtos.branchSeedDtos.BranchSeedDto;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Town;
import hiberspring.repository.BranchRepository;
import hiberspring.util.FileUtil;
import hiberspring.util.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;

@Service
@Transactional
public class BranchServiceImpl implements BranchService {
    private final BranchRepository branchRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final FileUtil fileUtil;
    private final TownService townService;

    @Autowired
    public BranchServiceImpl(BranchRepository branchRepository, Gson gson, ModelMapper modelMapper, ValidatorUtil validatorUtil, FileUtil fileUtil, TownService townService) {
        this.branchRepository = branchRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.fileUtil = fileUtil;

        this.townService = townService;
    }

    @Override
    public Boolean branchesAreImported() {
        return this.branchRepository.count() > 0;
    }

    @Override
    public String readBranchesJsonFile() throws IOException {
        return this.fileUtil.readFile(ConstantPath.BRANCH_PATH_LOCATION);
    }

    @Override
    public String importBranches(String branchesFileContent) throws IOException {
        StringBuilder sb = new StringBuilder();

        BranchSeedDto[] branchSeedDtos = this.gson.fromJson(readBranchesJsonFile(), BranchSeedDto[].class);

        for (BranchSeedDto branchSeedDto : branchSeedDtos) {

            if (this.validatorUtil.isValid(branchSeedDto)) {

                if (this.branchRepository.findByName(branchSeedDto.getName()) == null) {

                    Branch branch = this.modelMapper.map(branchSeedDto, Branch.class);

                    Town town = this.townService.getTownByName(branchSeedDto.getTown());

                    branch.setTown(town);

                    this.branchRepository.saveAndFlush(branch);

                    sb.append(String.format(Constants.SUCCESSFUL_IMPORT_BRANCH, branch.getName()))
                            .append(System.lineSeparator());

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
    public Branch getBranchByName(String name) {

        return this.branchRepository.findByName(name);
    }
}
