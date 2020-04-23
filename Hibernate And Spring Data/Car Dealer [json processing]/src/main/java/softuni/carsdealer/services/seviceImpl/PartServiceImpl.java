package softuni.carsdealer.services.seviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.carsdealer.domain.dtos.seedDtos.PartDtoSeed;
import softuni.carsdealer.domain.entities.Part;
import softuni.carsdealer.domain.entities.Supplier;
import softuni.carsdealer.repositories.PartRepository;
import softuni.carsdealer.services.PartService;
import softuni.carsdealer.services.SupplierService;
import softuni.carsdealer.utils.ValidationUtil;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
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
    @Transactional
    public void seedPart(PartDtoSeed[] partDtoSeeds) {
        for (PartDtoSeed partDto : partDtoSeeds) {
                if (this.validationUtil.isValid(partDto)) {
                    Part part = this.modelMapper.map(partDto, Part.class);

                    //Getting random supplier
                    Supplier supplier = this.supplierService.getRandomSupplier();

                    part.setSupplier(supplier);

                    if (this.partRepository.findByNameAndPrice(part.getName(), part.getPrice()) == null) {
                        this.partRepository.saveAndFlush(part);
                    }
                }
        }
    }

    @Override
    public List<Part> getRandomParts() {
        List<Part> parts = new ArrayList<>();
        int randomCount = this.random.nextInt(10 + 1) + 10;
        for (int i = 0; i < randomCount; i++) {
            int randomPartId = this.random.nextInt((int) this.partRepository.count()) + 1;
            Part part = this.partRepository.getOnePart(randomPartId);
            System.out.println();
            parts.add(part);
        }
        return parts;
    }
}
