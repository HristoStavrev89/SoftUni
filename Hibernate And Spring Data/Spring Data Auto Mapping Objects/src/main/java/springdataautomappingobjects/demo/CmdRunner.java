package springdataautomappingobjects.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springdataautomappingobjects.demo.services.dtos.CityDto;
import springdataautomappingobjects.demo.services.dtos.CitySeedDto;
import springdataautomappingobjects.demo.services.dtos.EmployeeSeedDto;
import springdataautomappingobjects.demo.services.dtos.EmployeeViewDto;
import springdataautomappingobjects.demo.services.service.CityService;
import springdataautomappingobjects.demo.services.service.EmployeeService;

@Component
public class CmdRunner implements CommandLineRunner {
    private final EmployeeService employeeService;
    private final CityService cityService;

    @Autowired
    public CmdRunner(EmployeeService employeeService, CityService cityService) {
        this.employeeService = employeeService;
        this.cityService = cityService;
    }


    @Override
    public void run(String... args) throws Exception {

//       EmployeeSeedDto employeeSeedDto = new EmployeeSeedDto("Ivan", "Draganov",5434.54, "Ruse");

//        CitySeedDto city1 = new CitySeedDto("Varna");
//        CitySeedDto city2 = new CitySeedDto("Ruse");
//        CitySeedDto city3 = new CitySeedDto("Pleven");
//        this.cityService.save(city1);
//        this.cityService.save(city2);
//        this.cityService.save(city3);
//        this.employeeService.save(employeeSeedDto);

        EmployeeViewDto employeeViewDto = this.employeeService.findByFirstAndLastName("Ivan", "Draganov");

        System.out.println();

    }
}
