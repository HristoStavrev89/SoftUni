package softuni.xmlcarsdealer.services;

import softuni.xmlcarsdealer.domain.dto.seedDtos.customerSeedDtos.CustomerSeedDto;
import softuni.xmlcarsdealer.domain.dto.xmlDtos.customerTotalSalesDto.CustomerSaleRootViewDto;
import softuni.xmlcarsdealer.domain.dto.xmlDtos.customerXmlDtos.CustomerRootViewDto;
import softuni.xmlcarsdealer.domain.dto.xmlDtos.customerXmlDtos.CustomerViewDto;
import softuni.xmlcarsdealer.domain.entities.Customer;

import java.util.List;

public interface CustomerService {


    void seedCustomers(List<CustomerSeedDto> customerSeedDtos);

    Customer getRandomCustomer();

    CustomerRootViewDto getAllOrderedByBirthDate();

    CustomerSaleRootViewDto getTotalSalesByCustomer();

}
