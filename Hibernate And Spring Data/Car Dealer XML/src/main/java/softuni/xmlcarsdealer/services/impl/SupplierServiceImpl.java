package softuni.xmlcarsdealer.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.xmlcarsdealer.domain.dto.seedDtos.supplierSeedDtos.SupplierSeedDto;
import softuni.xmlcarsdealer.domain.dto.xmlDtos.supplierXmlDtos.SupplierRootViewDto;
import softuni.xmlcarsdealer.domain.dto.xmlDtos.supplierXmlDtos.SupplierViewDto;
import softuni.xmlcarsdealer.domain.entities.Supplier;
import softuni.xmlcarsdealer.repositories.SupplierRepository;
import softuni.xmlcarsdealer.services.SupplierService;
import softuni.xmlcarsdealer.utils.ValidationUtil;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Random random;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Random random) {
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.random = random;
    }

    @Override
    public void seedSuppliers(List<SupplierSeedDto> supplierSeedDtos) {

        for (SupplierSeedDto supplierSeedDto : supplierSeedDtos) {
            if (this.validationUtil.isValid(supplierSeedDto)) {
                if (this.supplierRepository.findByName(supplierSeedDto.getName()) == null) {
                    Supplier seedDto = this.modelMapper.map(supplierSeedDto, Supplier.class);
                    this.supplierRepository.saveAndFlush(seedDto);
                } else {
                    System.out.println("Supplier with the given name already exist!");
                }
            } else {
                this.validationUtil
                        .getViolations(supplierSeedDto)
                        .stream()
                        .map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);
            }
        }

    }

    @Override
    public Supplier getRandomSupplier() {
        long randomId = this.random.nextInt((int) this.supplierRepository.count()) + 1;

        return this.supplierRepository.findById(randomId).orElse(null);

    }

    @Override
    public SupplierRootViewDto getAllAbroadIsFalse() {
        SupplierRootViewDto supplierRootViewDto = new SupplierRootViewDto();

        List<SupplierViewDto> supplierViewDtos = new ArrayList<>();

         this.supplierRepository.findAllByImporterIsFalse()
                 .forEach(supplier -> {
                     SupplierViewDto supp = this.modelMapper.map(supplier, SupplierViewDto.class);
                     supplierViewDtos.add(supp);
                     supp.setPartsCount(supplier.getParts().size());
                 });
        supplierRootViewDto.setSuppliers(supplierViewDtos);

        return supplierRootViewDto;
    }
}
