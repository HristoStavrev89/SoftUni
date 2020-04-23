package softuni.carsdealer.services;

import softuni.carsdealer.domain.dtos.seedDtos.SupplierDtoSeed;
import softuni.carsdealer.domain.dtos.viewDtos.localSupliers.SupplierDtoView;
import softuni.carsdealer.domain.entities.Supplier;

import java.util.List;

public interface SupplierService {

    void seedSuppliers(SupplierDtoSeed[] supplierDtoSeeds);

    Supplier getSupplierById(long id);

    long getSupplierRepositoryCount();

    Supplier getRandomSupplier();

    List<SupplierDtoView> getByImporterIsNotAbroad();

}
