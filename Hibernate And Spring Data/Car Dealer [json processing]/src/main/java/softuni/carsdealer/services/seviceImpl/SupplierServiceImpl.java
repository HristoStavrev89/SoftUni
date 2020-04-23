package softuni.carsdealer.services.seviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.carsdealer.domain.dtos.seedDtos.SupplierDtoSeed;
import softuni.carsdealer.domain.dtos.viewDtos.localSupliers.SupplierDtoView;
import softuni.carsdealer.domain.entities.Supplier;
import softuni.carsdealer.repositories.SupplierRepository;
import softuni.carsdealer.services.SupplierService;
import softuni.carsdealer.utils.ValidationUtil;

import javax.transaction.Transactional;
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
    public void seedSuppliers(SupplierDtoSeed[] supplierDtoSeeds) {
        for (SupplierDtoSeed dtoSeed : supplierDtoSeeds) {
            if (this.validationUtil.isValid(dtoSeed)) {

                Supplier supplier = this.modelMapper.map(dtoSeed, Supplier.class);


                if (this.supplierRepository.findByName(supplier.getName()) == null) {
                    this.supplierRepository.saveAndFlush(supplier);
                }
            }
        }
    }

    @Override
    public Supplier getSupplierById(long id) {
        return this.supplierRepository.getOne(id);
    }

    @Override
    public long getSupplierRepositoryCount() {
        return this.supplierRepository.count();
    }

    @Override
    public Supplier getRandomSupplier() {
        long randomId = this.random
                .nextInt( (int) this.supplierRepository.count()) + 1;

        return this.supplierRepository.getOne(randomId);

    }

    @Override
    public List<SupplierDtoView> getByImporterIsNotAbroad() {

        List<SupplierDtoView> suppliers = new ArrayList<>();

        this.supplierRepository.findAllByImporterIsFalse()
                .stream()
                .map(e -> {
                    SupplierDtoView supplierDtoView = this.modelMapper.map(e, SupplierDtoView.class);
                    supplierDtoView.setPartsCount(e.getParts().size());
                    return supplierDtoView;
                })
                .forEach(supp -> suppliers.add(supp));


        return suppliers;
    }
}
