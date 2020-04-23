package com.example.demo.implServices;

import com.example.demo.models.dtos.ProductInRangeDto;
import com.example.demo.models.dtos.ProductSeedDto;
import com.example.demo.models.entities.Category;
import com.example.demo.models.entities.Product;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.utils.ValidationUtil;
import com.example.services.CategoryService;
import com.example.services.ProductService;
import com.example.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final UserService userService;
    private final CategoryService categoryService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, ValidationUtil validationUtil, UserService userService, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.userService = userService;
        this.categoryService = categoryService;
    }


    @Override
    public void seedProducts(ProductSeedDto[] productSeedDtos) {

//        if (this.productRepository.count() != 0) {
//            return;
//        }

        Arrays.stream(productSeedDtos)
                .forEach(current -> {
                    if (validationUtil.isValid(current)) {
                        Product product = this.modelMapper.map(current, Product.class);

                        product.setSeller(this.userService.getRandomUser());

                        Random random = new Random();
                        int randomNum = random.nextInt(2);
                        if (randomNum == 1) {
                            product.setBuyer(this.userService.getRandomUser());
                        }

                        product.setCategories(new HashSet<>(this.categoryService.getRandomCategories()));


                        if (this.productRepository.findByNameAndPrice(product.getName() ,product.getPrice()) == null) {
                            this.productRepository.saveAndFlush(product);
                        }


                    } else {
                        this.validationUtil.getViolations(current)
                                .stream()
                                .map(ConstraintViolation::getMessage)
                                .forEach(System.out::println);
                    }

                });
    }

    @Override
    public List<ProductInRangeDto> getAllProductsInRange() {

        //Only for the testing
//        BigDecimal a = new BigDecimal(500);
//        BigDecimal b = new BigDecimal(100);

        return this.productRepository
                .findAllByPriceBetweenAndBuyerIsNull(BigDecimal.valueOf(500), BigDecimal.valueOf(1000))
                .stream()
                .map(p -> {
                    ProductInRangeDto productInRangeDto = this.modelMapper.map(p, ProductInRangeDto.class);

                    productInRangeDto
                            .setSeller(String.format("%s %s",
                                    p.getSeller().getFirstName(), p.getSeller().getLastName()));
                    return productInRangeDto;
                }).collect(Collectors.toList());
    }
}
