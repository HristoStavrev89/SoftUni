package softuni.xmlcarsdealer.services;

import softuni.xmlcarsdealer.domain.dto.seedDtos.supplierSeedDtos.SupplierSeedDto;
import softuni.xmlcarsdealer.domain.dto.seedDtos.supplierSeedDtos.SupplierSeedRoodDto;
import softuni.xmlcarsdealer.domain.dto.xmlDtos.supplierXmlDtos.SupplierRootViewDto;
import softuni.xmlcarsdealer.domain.entities.Supplier;

import java.util.List;

public interface SupplierService {

    void seedSuppliers(List<SupplierSeedDto> supplierSeedDtos);

    Supplier getRandomSupplier();

    SupplierRootViewDto getAllAbroadIsFalse();

}
