package softuni.xmlcarsdealer.services.impl;

import org.springframework.stereotype.Service;
import softuni.xmlcarsdealer.domain.entities.Discount;
import softuni.xmlcarsdealer.domain.entities.Sale;
import softuni.xmlcarsdealer.repositories.SaleRepository;
import softuni.xmlcarsdealer.services.CarService;
import softuni.xmlcarsdealer.services.CustomerService;
import softuni.xmlcarsdealer.services.SaleService;

import javax.transaction.Transactional;
import java.util.Random;

@Service
@Transactional
public class SaleServiceImpl implements SaleService {
    private final static int COUNT_SALES = 100;

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
    public void seedSales() {
        for (int i = 0; i < COUNT_SALES; i++) {
            Sale sale = new Sale();

            sale.setCar(this.carService.getRandomCar());
            sale.setCustomer(this.customerService.getRandomCustomer());
            sale.setDiscountPercentage(this.setRandomDiscount());

            this.saleRepository.saveAndFlush(sale);

        }
    }


    private double setRandomDiscount() {
        int randomNum = this.random.nextInt(7);

        Discount disc = Discount.values()[randomNum];

        double num = disc.getValueNum() * 1.0 / 100;

        return num;
    }


}
