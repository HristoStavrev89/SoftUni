package com.example.demo.implServices;

import com.example.demo.models.dtos.CategorySeedDto;
import com.example.demo.models.dtos.exercise2.CategoriesProductsDto;
import com.example.demo.models.entities.Category;
import com.example.demo.models.entities.Product;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.utils.ValidationUtil;
import com.example.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;


    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedCategories(CategorySeedDto[] categorySeedDto) {


//        if (this.categoryRepository.count() != 0) {
//            return;
//        }

        Arrays.stream(categorySeedDto)
                .forEach(current -> {
                    if (this.validationUtil.isValid(current)) {
                        Category category = this.modelMapper.map(current, Category.class);

                       if (this.categoryRepository.findByName(category.getName()) == null) {
                           this.categoryRepository.saveAndFlush(category);
                       }

                    } else {
                        this.validationUtil
                                .getViolations(current)
                                .stream()
                                .map(ConstraintViolation::getMessage)
                                .forEach(System.out::println);
                    }
                });

    }

    @Override
    public List<Category> getRandomCategories() {
        Random random = new Random();
        List<Category> resultList = new ArrayList<>();
        int randomCounter = random.nextInt(3) + 1;
        for (int i = 0; i < randomCounter; i++) {
            long randomId = random.nextInt((int) this.categoryRepository.count()) + 1;
            resultList.add(this.categoryRepository.getOne(randomId));
        }
        return resultList;
    }

    @Override
    public List<CategoriesProductsDto> categoriesByProductsCount() {
        List<Category> categoryList = this.categoryRepository.getAllCategories();

        List<CategoriesProductsDto> categoriesProductsDtoList = categoryList
                .stream()
                .map(category -> {
                    CategoriesProductsDto categoriesProductsDto = this.modelMapper.map(category, CategoriesProductsDto.class);

                    BigDecimal sumOfPrice = new BigDecimal(category.getProducts().size());

                    category
                            .getProducts()
                            .stream()
                            .forEach(e -> sumOfPrice.add(e.getPrice()));

                    BigDecimal average = sumOfPrice.divide(BigDecimal.valueOf(category.getProducts().size()));


                    categoriesProductsDto.setCategory(category.getName());
                    categoriesProductsDto.setProductsCount(category.getProducts().size());
                    categoriesProductsDto.setAveragePrice(average);
                    categoriesProductsDto.setTotalRevenue(sumOfPrice);

                  return categoriesProductsDto;
                }).collect(Collectors.toList());

        return categoriesProductsDtoList;
    }


}
