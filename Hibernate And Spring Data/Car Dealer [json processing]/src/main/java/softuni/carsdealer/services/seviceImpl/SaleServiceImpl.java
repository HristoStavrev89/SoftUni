package softuni.carsdealer.services.seviceImpl;

import org.springframework.stereotype.Service;
import softuni.carsdealer.domain.entities.Car;
import softuni.carsdealer.domain.entities.Customer;
import softuni.carsdealer.domain.entities.Discount;
import softuni.carsdealer.domain.entities.Sale;
import softuni.carsdealer.repositories.SaleRepository;
import softuni.carsdealer.services.CarService;
import softuni.carsdealer.services.CustomerService;
import softuni.carsdealer.services.SaleService;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
@Transactional
public class SaleServiceImpl implements SaleService {
    private final static int NUMBER_OF_SALES = 200;

    private final SaleRepository saleRepository;
    private final CarService carService;
    private final CustomerService customerService;
    private final Random random;


    public SaleServiceImpl(SaleRepository saleRepository, CarService carService, CustomerService customerService, Random random) {
        this.saleRepository = saleRepository;
        this.carService = carService;
        this.customerService = customerService;
        this.random = random;
    }


    @Override
    public void seedSale() {
        Set<Long> carsIdsSet = new HashSet<>();
        int randomCountSales = this.random.nextInt(NUMBER_OF_SALES) + 1;

        for (int i = 0; i < randomCountSales; i++) {

            Car car = this.carService.getRandomCar();

            if (carsIdsSet.contains(car.getId())) {
                continue;
            }

            carsIdsSet.add(car.getId());

            Sale sale = new Sale();
            Customer customer = this.customerService.getRandomCustomer();

            int numOfDiscounts = Discount.values().length - 1;
            int randomNum = this.random.nextInt(numOfDiscounts);
            Discount discount = Discount.values()[randomNum];
            double discountPercent = discount.getValueNum() * 1.0 / 100;

            sale.setCar(car);
            sale.setCustomer(customer);
            sale.setDiscountPercentage(discountPercent);
            this.saleRepository.saveAndFlush(sale);

        }
    }
}
