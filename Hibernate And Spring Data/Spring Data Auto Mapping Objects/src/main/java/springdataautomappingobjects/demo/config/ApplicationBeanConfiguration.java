package springdataautomappingobjects.demo.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springdataautomappingobjects.demo.data.entities.Employee;
import springdataautomappingobjects.demo.services.dtos.EmployeeViewDto;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public ModelMapper modelMapper() {

        //Custom mapping
        //The new variant with TypeMap
//                ModelMapper modelMapper = new ModelMapper();
//        TypeMap<Employee, EmployeeViewDto> typeMap = modelMapper.createTypeMap(Employee.class, EmployeeViewDto.class);
//        typeMap.addMappings(m -> m.map(src -> src.getCity().getName(), EmployeeViewDto::setAddress));
//        return modelMapper;

        //Second variant for custom mapping
//        ModelMapper modelMapper = new ModelMapper();
//
//        PropertyMap<Employee, EmployeeViewDto> propertyMap = new PropertyMap<Employee, EmployeeViewDto>() {
//            @Override
//            protected void configure() {
//                map().setAddress(source.getCity().getName());
//            }
//        };
//
//       modelMapper.addMappings(propertyMap);
//        return modelMapper;

        //When the names on the fields are correct/matched
        return new ModelMapper();
    }
}
