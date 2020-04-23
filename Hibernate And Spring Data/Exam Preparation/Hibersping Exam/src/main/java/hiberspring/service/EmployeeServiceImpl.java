package hiberspring.service;

import hiberspring.domain.dtos.employeeDtos.employeeSeedDtos.EmployeeRootSeedDto;
import hiberspring.domain.dtos.employeeDtos.employeeSeedDtos.EmployeeSeedDto;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Employee;
import hiberspring.domain.entities.EmployeeCard;
import hiberspring.repository.EmployeeRepository;
import hiberspring.util.FileUtil;
import hiberspring.util.ValidatorUtil;
import hiberspring.util.xmlParser.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static hiberspring.common.ConstantPath.EMPLOYEES_PATH_LOCATION;
import static hiberspring.common.Constants.*;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    private final XmlParser xmlParser;
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final FileUtil fileUtil;
    private final BranchService branchService;
    private final EmployeeCardService employeeCardService;

    @Autowired
    public EmployeeServiceImpl(XmlParser xmlParser, EmployeeRepository employeeRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, FileUtil fileUtil, BranchService branchService, EmployeeCardService employeeCardService) {
        this.xmlParser = xmlParser;
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.fileUtil = fileUtil;
        this.branchService = branchService;
        this.employeeCardService = employeeCardService;
    }


    @Override
    public Boolean employeesAreImported() {
        return this.employeeRepository.count() > 0;
    }

    @Override
    public String readEmployeesXmlFile() throws IOException {
        return this.fileUtil.readFile(EMPLOYEES_PATH_LOCATION);
    }

    @Override
    public String importEmployees() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        EmployeeRootSeedDto employeeRootSeedDto = this.xmlParser.importFromXml(EMPLOYEES_PATH_LOCATION, EmployeeRootSeedDto.class);

        for (EmployeeSeedDto employeeDto : employeeRootSeedDto.getEmployees()) {

            if (this.validatorUtil.isValid(employeeDto)) {

                if (this.employeeRepository.findByFirstNameAndLastNameAndPosition(employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getPosition()) == null) {

                    Employee employee = this.modelMapper.map(employeeDto, Employee.class);

                    EmployeeCard employeeCard = this.employeeCardService.getCardByNumber(employeeDto.getCard());

                    Branch branch = this.branchService.getBranchByName(employeeDto.getBranch());

                    employee.setCard(employeeCard);
                    employee.setBranch(branch);


                    if (employeeCard != null && branch != null) {
                        this.employeeRepository.saveAndFlush(employee);

                        sb.append(String.format(SUCCESSFUL_IMPORT_EMPLOYEE, employee.getFirstName(), employee.getLastName()))
                                .append(System.lineSeparator());
                    }
                } else {
                    sb.append(ALREADY_IN_THE_DATABASE).append(System.lineSeparator());
                }
            } else {
                sb.append(INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
            }

        }

        return sb.toString();
    }

    @Override
    public String exportProductiveEmployees() {
        StringBuilder sb = new StringBuilder();

        List<Employee> employees = this.employeeRepository.findAllByBranchProducts();

        employees.forEach(employee -> {

            sb.append(String.format("Name: %s %s", employee.getFirstName(), employee.getLastName())).append(System.lineSeparator());
            sb.append(String.format("Position: %s", employee.getPosition())).append(System.lineSeparator());
            sb.append(String.format("Card Number: %s", employee.getCard().getNumber())).append(System.lineSeparator());
            sb.append("-".repeat(35)).append(System.lineSeparator());


        });


        return sb.toString();
    }
}
