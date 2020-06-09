package softuni.workshop.service.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.workshop.data.dto.employeeDto.EmployeeDto;
import softuni.workshop.data.dto.employeeDto.EmployeeRootDto;
import softuni.workshop.data.entities.Employee;
import softuni.workshop.data.entities.Project;
import softuni.workshop.data.repositories.EmployeeRepository;
import softuni.workshop.data.repositories.ProjectRepository;
import softuni.workshop.service.services.EmployeeService;
import softuni.workshop.util.XmlParser;
import softuni.workshop.web.models.EmployeeViewModel;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final String XML_EMPLOYEES_PATH = "src/main/resources/files/xmls/employees.xml";

    private final EmployeeRepository employeeRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ProjectRepository projectRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, XmlParser xmlParser, ModelMapper modelMapper, ProjectRepository projectRepository) {
        this.employeeRepository = employeeRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.projectRepository = projectRepository;
    }


    @Override
    public void importEmployees() throws JAXBException {
        EmployeeRootDto employeeRootDto = this.xmlParser.importXML(EmployeeRootDto.class, XML_EMPLOYEES_PATH);

        for (EmployeeDto employeeDto :employeeRootDto.getEmployeeDtos()) {
            Employee employee = this.modelMapper.map(employeeDto, Employee.class);

            Project project = this.projectRepository.findByName(employeeDto.getProjectDto().getName());

            employee.setProject(project);

            this.employeeRepository.saveAndFlush(employee);

        }
    }

    @Override
    public boolean areImported() {

       return this.employeeRepository.count() > 0;
    }

    @Override
    public String readEmployeesXmlFile() {
        String xml = "";
        try {
            xml = Files.readString(Path.of(XML_EMPLOYEES_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return xml;
    }

    @Override
    public String exportEmployeesWithAgeAbove() {
        StringBuilder sb = new StringBuilder();

        findAllByAge().stream()
                .forEach(e -> {
                    sb.append(e.toString())
                            .append(System.lineSeparator());
                });

        return sb.toString().trim();
    }

    @Override
    public List<EmployeeViewModel> findAllByAge() {
        return this.employeeRepository
                .findAllByAgeGreaterThan(25)
                .stream()
                .map(employee -> this.modelMapper.map(employee, EmployeeViewModel.class))
                .collect(Collectors.toList());
    }
}
