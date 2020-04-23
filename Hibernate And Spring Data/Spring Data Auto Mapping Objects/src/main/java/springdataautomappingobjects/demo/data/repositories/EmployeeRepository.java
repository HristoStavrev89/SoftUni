package springdataautomappingobjects.demo.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springdataautomappingobjects.demo.data.entities.Employee;
import springdataautomappingobjects.demo.services.dtos.EmployeeSeedDto;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    Employee findByFirstNameAndLastName(String firstName, String lastName);

}
