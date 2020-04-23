package springdataautomappingobjects.demo.services.service;

import springdataautomappingobjects.demo.services.dtos.CityDto;
import springdataautomappingobjects.demo.services.dtos.CitySeedDto;

public interface CityService {

    void save(CitySeedDto city);

    CityDto findByName(String name);

}
