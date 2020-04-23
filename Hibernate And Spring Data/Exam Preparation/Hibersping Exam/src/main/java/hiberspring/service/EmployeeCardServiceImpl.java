package hiberspring.service;

import com.google.gson.Gson;
import hiberspring.common.Constants;
import hiberspring.domain.dtos.employeeCardSeedDto.EmployeeCardSeedDto;
import hiberspring.domain.entities.EmployeeCard;
import hiberspring.repository.EmployeeCardRepository;
import hiberspring.util.FileUtil;
import hiberspring.util.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;

import static hiberspring.common.ConstantPath.EMPLOYEE_CARD_PATH_LOCATION;
import static hiberspring.common.Constants.SUCCESSFUL_IMPORT_EMPLOYEE_CARD;

@Service
@Transactional
public class EmployeeCardServiceImpl implements EmployeeCardService {
    private final Gson gson;
    private final EmployeeCardRepository employeeCardRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final FileUtil fileUtil;

    public EmployeeCardServiceImpl(Gson gson, EmployeeCardRepository employeeCardRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, FileUtil fileUtil) {
        this.gson = gson;
        this.employeeCardRepository = employeeCardRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.fileUtil = fileUtil;
    }


    @Override
    public Boolean employeeCardsAreImported() {
        return this.employeeCardRepository.count() > 0;
    }

    @Override
    public String readEmployeeCardsJsonFile() throws IOException {
        return this.fileUtil.readFile(EMPLOYEE_CARD_PATH_LOCATION);
    }

    @Override
    public String importEmployeeCards(String employeeCardsFileContent) throws IOException {
        StringBuilder sb = new StringBuilder();

        EmployeeCardSeedDto[] employeeCardSeedDtos = this.gson.fromJson(readEmployeeCardsJsonFile(), EmployeeCardSeedDto[].class);

        for (EmployeeCardSeedDto cardSeedDto : employeeCardSeedDtos) {

            if (this.validatorUtil.isValid(cardSeedDto)) {

                if (this.employeeCardRepository.findByNumber(cardSeedDto.getNumber()) == null) {

                    EmployeeCard employeeCard = this.modelMapper.map(cardSeedDto, EmployeeCard.class);

                    this.employeeCardRepository.saveAndFlush(employeeCard);

                    sb.append(String.format(SUCCESSFUL_IMPORT_EMPLOYEE_CARD, employeeCard.getNumber()))
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
    public EmployeeCard getCardByNumber(String cardNumber) {

        return this.employeeCardRepository.findByNumber(cardNumber);
    }
}
