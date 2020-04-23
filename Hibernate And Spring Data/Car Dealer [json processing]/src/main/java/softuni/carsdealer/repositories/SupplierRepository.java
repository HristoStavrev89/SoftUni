package softuni.carsdealer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.carsdealer.domain.entities.Supplier;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {


    Supplier findByName(String name);

 //   List<Supplier> findAllByImporter(boolean importer);

    @Query("SELECT s FROM Supplier AS s WHERE s.importer = false")
    List<Supplier> findAllByImporterIsFalse();

}
