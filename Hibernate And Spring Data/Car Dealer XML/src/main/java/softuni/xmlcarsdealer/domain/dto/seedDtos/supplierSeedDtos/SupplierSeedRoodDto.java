package softuni.xmlcarsdealer.domain.dto.seedDtos.supplierSeedDtos;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierSeedRoodDto {


    @XmlElement(name = "supplier")
    private List<SupplierSeedDto> suppliers;

    public SupplierSeedRoodDto() {
    }


    public List<SupplierSeedDto> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<SupplierSeedDto> suppliers) {
        this.suppliers = suppliers;
    }
}
