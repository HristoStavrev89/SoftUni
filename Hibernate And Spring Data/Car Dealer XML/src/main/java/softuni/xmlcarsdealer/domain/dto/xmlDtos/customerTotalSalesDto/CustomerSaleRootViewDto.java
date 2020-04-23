package softuni.xmlcarsdealer.domain.dto.xmlDtos.customerTotalSalesDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerSaleRootViewDto {

    @XmlElement(name = "customer")
    private List<CustomerSaleViewDto> customers;

    public CustomerSaleRootViewDto() {
    }

    public List<CustomerSaleViewDto> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerSaleViewDto> customers) {
        this.customers = customers;
    }
}
