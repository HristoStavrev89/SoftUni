package springdataautomappingobjects.demo.services.service.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdataautomappingobjects.demo.data.entities.City;
import springdataautomappingobjects.demo.data.entities.Employee;
import springdataautomappingobjects.demo.data.repositories.EmployeeRepository;
import springdataautomappingobjects.demo.services.dtos.CityDto;
import springdataautomappingobjects.demo.services.dtos.EmployeeSeedDto;
import springdataautomappingobjects.demo.services.dtos.EmployeeViewDto;
import springdataautomappingobjects.demo.services.service.CityService;
import springdataautomappingobjects.demo.services.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final ModelMapper modelMapper;
    private final EmployeeRepository employeeRepository;
    private final CityService cityService;

    @Autowired
    public EmployeeServiceImpl(ModelMapper modelMapper, EmployeeRepository employeeRepository, CityService cityService) {
        this.modelMapper = modelMapper;
        this.employeeRepository = employeeRepository;
        this.cityService = cityService;
    }

    @Override
    public void save(EmployeeSeedDto employeeSeedDto) {

        Employee employee = this.modelMapper.map(employeeSeedDto, Employee.class);

        CityDto city = this.cityService.findByName(employeeSeedDto.getAddressCity());

        employee.setCity(this.modelMapper.map(city, City.class));
        this.employeeRepository.save(employee);

    }

    @Override
    public EmployeeViewDto findByFirstAndLastName(String fn, String ln) {
      return this.modelMapper
              .map(this.employeeRepository.findByFirstNameAndLastName(fn, ln), EmployeeViewDto.class);
    }


}
