package softuni.carsdealer.services;

import softuni.carsdealer.domain.dtos.seedDtos.CustomerDtoSeed;
import softuni.carsdealer.domain.dtos.viewDtos.orderedCustomers.CustomerDtoView;
import softuni.carsdealer.domain.dtos.viewDtos.totalSalesByCustomer.CustomerSalesDtoView;
import softuni.carsdealer.domain.entities.Customer;

import java.util.List;

public interface CustomerService {

    void seedCustomer(CustomerDtoSeed[] customerDtoSeeds);

    Customer getRandomCustomer();

    List<CustomerDtoView> getCustomersOrderedByBirthDate();

    List<CustomerSalesDtoView> getAllCustomersAtLEastOneCar();

}
