package softuni.xmlcarsdealer.domain.dto.xmlDtos.customerXmlDtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerRootViewDto {

    @XmlElement(name = "customer")
    List<CustomerViewDto> customers;

    public CustomerRootViewDto() {
        this.customers = new ArrayList<>();
    }


    public List<CustomerViewDto> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerViewDto> customers) {
        this.customers = customers;
    }
}
