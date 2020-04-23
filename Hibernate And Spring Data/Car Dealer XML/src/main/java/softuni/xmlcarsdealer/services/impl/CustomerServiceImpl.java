package softuni.xmlcarsdealer.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.xmlcarsdealer.domain.dto.seedDtos.customerSeedDtos.CustomerSeedDto;
import softuni.xmlcarsdealer.domain.dto.xmlDtos.customerTotalSalesDto.CustomerSaleRootViewDto;
import softuni.xmlcarsdealer.domain.dto.xmlDtos.customerTotalSalesDto.CustomerSaleViewDto;
import softuni.xmlcarsdealer.domain.dto.xmlDtos.customerXmlDtos.CustomerRootViewDto;
import softuni.xmlcarsdealer.domain.dto.xmlDtos.customerXmlDtos.CustomerViewDto;
import softuni.xmlcarsdealer.domain.entities.Customer;
import softuni.xmlcarsdealer.domain.entities.Part;
import softuni.xmlcarsdealer.domain.entities.Sale;
import softuni.xmlcarsdealer.repositories.CustomerRepository;
import softuni.xmlcarsdealer.services.CustomerService;
import softuni.xmlcarsdealer.utils.ValidationUtil;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Random random;

    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Random random) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.random = random;
    }



    @Override
    public void seedCustomers(List<CustomerSeedDto> customerSeedDtos) {

        for (CustomerSeedDto customerSeedDto : customerSeedDtos) {
            if (this.validationUtil.isValid(customerSeedDto)) {

                if (this.customerRepository.findByNameAndBirthDate(customerSeedDto.getName(), customerSeedDto.getBirthDate()) == null) {
                    Customer customer = this.modelMapper.map(customerSeedDto, Customer.class);

                    this.customerRepository.saveAndFlush(customer);
                } else {
                    System.out.println(String.format("%s with birth date %s is already in the data-base."
                    , customerSeedDto.getName()
                    , customerSeedDto.getBirthDate().toString()));
                }
            } else {
                this.validationUtil.getViolations(customerSeedDto)
                        .stream()
                        .map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);
            }
        }


    }

    @Override
    public Customer getRandomCustomer() {
        long customerId = this.random.nextInt((int) this.customerRepository.count()) + 1;
        return this.customerRepository.findById(customerId).orElse(null);
    }

    @Override
    public CustomerRootViewDto getAllOrderedByBirthDate() {

        CustomerRootViewDto customerRootViewDto = new CustomerRootViewDto();

        List<Customer> customers = this.customerRepository.findCustomersOrderedByBirthDateAndYoungDriver();
        for (Customer customer : customers) {
            CustomerViewDto customerViewDto = this.modelMapper.map(customer, CustomerViewDto.class);

            customerRootViewDto.getCustomers().add(customerViewDto);
        }

        return customerRootViewDto;
    }

    @Override
    public CustomerSaleRootViewDto getTotalSalesByCustomer() {
        CustomerSaleRootViewDto customerSaleRootViewDto = new CustomerSaleRootViewDto();
        List<CustomerSaleViewDto> customerSaleViewDtos = new ArrayList<>();

        List<Customer> customersList = this.customerRepository.findAll()
                .stream()
                .filter(c -> c.getSales().size() > 0)
                .collect(Collectors.toList());

        for (Customer customer : customersList) {
            CustomerSaleViewDto customerSaleViewDto = new CustomerSaleViewDto();
            customerSaleViewDto.setName(customer.getName());

            BigDecimal spentMoneyCustomer = getSpentMoneyByCustomer(customer);

            customerSaleViewDto.setSpendMoney(spentMoneyCustomer);
            customerSaleViewDto.setBoughtCars(customer.getSales().size());

            customerSaleViewDtos.add(customerSaleViewDto);

        }

        List<CustomerSaleViewDto> sortetCustomerSalesViewDtos =  customerSaleViewDtos.stream()
                .sorted((a, b) -> {
                    int sort = b.getSpendMoney().compareTo(a.getSpendMoney());
                    if (sort == 0) {
                        sort = Integer.compare(b.getBoughtCars(), a.getBoughtCars());
                    }
                    return sort;
                }).collect(Collectors.toList());


        customerSaleRootViewDto.setCustomers(sortetCustomerSalesViewDtos);




        return customerSaleRootViewDto;
    }

    private BigDecimal getSpentMoneyByCustomer(Customer customer) {
        BigDecimal totalMoney = new BigDecimal(0);
        for (Sale sale : customer.getSales()) {

            BigDecimal spent = new BigDecimal(0);

            for (Part part : sale.getCar().getParts()) {
            spent = spent.add(part.getPrice());
            }

            spent = spent.subtract(spent.multiply(BigDecimal.valueOf(sale.getDiscountPercentage())));

            totalMoney = totalMoney.add(spent);
        }

        return totalMoney;
    }
}
