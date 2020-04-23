package springdataautomappingobjects.demo.services.service.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdataautomappingobjects.demo.data.entities.City;
import springdataautomappingobjects.demo.data.repositories.CityRepository;
import springdataautomappingobjects.demo.services.dtos.CityDto;
import springdataautomappingobjects.demo.services.dtos.CitySeedDto;
import springdataautomappingobjects.demo.services.service.CityService;

@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository, ModelMapper modelMapper) {
        this.cityRepository = cityRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void save(CitySeedDto city) {
        this.cityRepository.save(this.modelMapper.map(city, City.class));
    }

    @Override
    public CityDto findByName(String name) {
        return this.modelMapper.map(this.cityRepository.findByName(name), CityDto.class);
    }
}
