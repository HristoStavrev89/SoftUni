package springdataautomappingobjects.demo.services.service;

import springdataautomappingobjects.demo.data.entities.Employee;
import springdataautomappingobjects.demo.services.dtos.EmployeeSeedDto;
import springdataautomappingobjects.demo.services.dtos.EmployeeViewDto;

public interface EmployeeService {

   void save(EmployeeSeedDto employeeSeedDto);

   EmployeeViewDto findByFirstAndLastName(String fn, String ln);

}
