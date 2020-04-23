package softuni.carsdealer.services.seviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.carsdealer.domain.dtos.seedDtos.CustomerDtoSeed;
import softuni.carsdealer.domain.dtos.viewDtos.orderedCustomers.CustomerDtoView;
import softuni.carsdealer.domain.dtos.viewDtos.totalSalesByCustomer.CustomerSalesDtoView;
import softuni.carsdealer.domain.entities.Customer;
import softuni.carsdealer.domain.entities.Part;
import softuni.carsdealer.domain.entities.Sale;
import softuni.carsdealer.repositories.CustomerRepository;
import softuni.carsdealer.services.CustomerService;
import softuni.carsdealer.utils.ValidationUtil;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private static final BigDecimal YOUNG_DRIVER_DISCOUNT_VALUE = BigDecimal.valueOf(0.05);

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Random random;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Random random) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.random = random;
    }


    @Override
    public void seedCustomer(CustomerDtoSeed[] customerDtoSeeds) {
        for (CustomerDtoSeed dtoSeed : customerDtoSeeds) {
            if (this.validationUtil.isValid(dtoSeed)) {

                Customer customer = this.modelMapper.map(dtoSeed, Customer.class);

                if (this.customerRepository.findByNameAndBirthDate(customer.getName(), customer.getBirthDate()) == null) {
                    this.customerRepository.saveAndFlush(customer);
                }
            }
        }
    }

    @Override
    public Customer getRandomCustomer() {
        long customerId = this.random.nextInt((int) customerRepository.count()) + 1;

        return this.customerRepository.findById(customerId).orElse(null);
    }

    @Override
    public List<CustomerDtoView> getCustomersOrderedByBirthDate() {
        List<CustomerDtoView> customerDtoViewList = new ArrayList<>();
        this.customerRepository.findAllOrderByBirthDate()
                .stream()
                .sorted((a, b) -> {
                    int sort = 0;
                    if (a.isYoungDriver()) {
                        sort = 1;
                    } else if (b.isYoungDriver()) {
                        sort = -1;
                    }
                    return sort;

                }).forEach(customer -> {
                    CustomerDtoView customerDtoView = this.modelMapper.map(customer, CustomerDtoView.class);
                    customerDtoViewList.add(customerDtoView);
        });

        return customerDtoViewList;
    }

    @Override
    public List<CustomerSalesDtoView> getAllCustomersAtLEastOneCar() {
        List<CustomerSalesDtoView> customers = new ArrayList<>();

        this.customerRepository
                .findAll()
                .stream()
                .filter(c -> c.getSales().size() > 0)
                .forEach(customer -> {
                    CustomerSalesDtoView convert = putModelViewToCustomer(customer);
                    customers.add(convert);
                });

        return customers
                .stream()
                .sorted((a, b) -> {
                    int sort = b.getSpentMoney().compareTo(a.getSpentMoney());
                    if (sort == 0) {
                        sort = b.getBoughtCars() - a.getBoughtCars();
                    }
                    return sort;
                }).collect(Collectors.toList());
    }

    private CustomerSalesDtoView putModelViewToCustomer(Customer customer) {
        CustomerSalesDtoView convert = new CustomerSalesDtoView();

        convert.setFullName(customer.getName());
        convert.setBoughtCars(customer.getSales().size());
        BigDecimal totalMoneySpend = getTotalSpendMoney(customer.getSales());

        if (customer.isYoungDriver()) {
            BigDecimal discount = totalMoneySpend.multiply(CustomerServiceImpl.YOUNG_DRIVER_DISCOUNT_VALUE);
            totalMoneySpend = totalMoneySpend.subtract(discount);
        }

        convert.setSpentMoney(totalMoneySpend);

        return convert;
    }

    private BigDecimal getTotalSpendMoney(Set<Sale> sales) {
        BigDecimal totalMoney = new BigDecimal(0);
        for (Sale sale : sales) {
            BigDecimal sum = sale
                    .getCar()
                    .getParts()
                    .stream()
                    .map(Part::getPrice)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal discount = sum.multiply(BigDecimal.valueOf(sale.getDiscountPercentage()));
            sum = sum.subtract(discount);
            totalMoney = totalMoney.add(sum);
        }
        return totalMoney;
    }
}
