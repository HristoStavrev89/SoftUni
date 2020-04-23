package softuni.carsdealer.domain.dtos.seedDtos;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

public class SupplierDtoSeed {

    @Expose
    private String name;
    @Expose
    private boolean isImporter;


    public SupplierDtoSeed() {
    }

    @Length(min = 2, message = "Name must be at least 2 characters.")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isImporter() {
        return isImporter;
    }

    public void setImporter(boolean importer) {
        isImporter = importer;
    }
}
