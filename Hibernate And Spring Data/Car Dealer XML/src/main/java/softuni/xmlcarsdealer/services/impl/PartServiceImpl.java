package softuni.xmlcarsdealer.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.xmlcarsdealer.domain.dto.seedDtos.partSeedDtos.PartSeedDto;
import softuni.xmlcarsdealer.domain.entities.Part;
import softuni.xmlcarsdealer.domain.entities.Supplier;
import softuni.xmlcarsdealer.repositories.PartRepository;
import softuni.xmlcarsdealer.services.PartService;
import softuni.xmlcarsdealer.services.SupplierService;
import softuni.xmlcarsdealer.utils.ValidationUtil;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class PartServiceImpl implements PartService {
    private final PartRepository partRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final SupplierService supplierService;
    private final Random random;

    public PartServiceImpl(PartRepository partRepository, ModelMapper modelMapper, ValidationUtil validationUtil, SupplierService supplierService, Random random) {
        this.partRepository = partRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.supplierService = supplierService;
        this.random = random;
    }


    @Override
    public void seedParts(List<PartSeedDto> partSeedDtoList) {
        for (PartSeedDto partSeedDto : partSeedDtoList) {
            if (this.validationUtil.isValid(partSeedDto)) {
                if (this.partRepository.findByNameAndPrice(partSeedDto.getName(), partSeedDto.getPrice()) == null) {
                    Supplier supplier = this.supplierService.getRandomSupplier();

                    Part part = this.modelMapper.map(partSeedDto, Part.class);
                    part.setSupplier(supplier);


                    this.partRepository.saveAndFlush(part);
                }
            } else {
                this.validationUtil.getViolations(partSeedDto)
                        .stream()
                        .map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);
            }
        }


    }

    @Override
    public Part getRandomPart() {

        long partId = this.random.nextInt((int) this.partRepository.count()) + 1;

        return this.partRepository.findById(partId).orElse(null);
    }

    @Override
    public List<Part> getListWithRandomParts() {
        List<Part> parts = new ArrayList<>();

        int randomCount = this.random.nextInt(10) + 11;
        for (int i = 0; i < randomCount; i++) {
            parts.add(getRandomPart());
        }

        return parts;
    }


}
