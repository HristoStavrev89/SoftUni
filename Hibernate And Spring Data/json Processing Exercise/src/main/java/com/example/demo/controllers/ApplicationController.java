package com.example.demo.controllers;

import com.example.demo.constants.GlobalConstants;
import com.example.demo.models.dtos.CategorySeedDto;
import com.example.demo.models.dtos.ProductInRangeDto;
import com.example.demo.models.dtos.ProductSeedDto;
import com.example.demo.models.dtos.UserSeedDto;
import com.example.demo.models.dtos.exercise2.CategoriesProductsDto;
import com.example.demo.models.dtos.exerciseOne.UserSoldProductsDto;
import com.example.demo.models.dtos.exerciseOne.usersAndProducts.UserCountDto;
import com.example.demo.utils.FileUtil;
import com.example.services.CategoryService;
import com.example.services.ProductService;
import com.example.services.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

@Component
public class ApplicationController implements CommandLineRunner {

    private final Gson gson;
    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;
    private final FileUtil fileUtil;




    @Autowired
    public ApplicationController(Gson gson, CategoryService categoryService, UserService userService, ProductService productService, FileUtil fileUtil) {
        this.gson = gson;
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
        this.fileUtil = fileUtil;
    }


    @Override
    public void run(String... args) throws Exception {

        this.seedCategories();
        this.seedUsers();
        this.seedProducts();
        this.writeProductInRange();

        this.getAllUsersWithAtLEastOneProductSold();

        this.categoriesByCount();

        this.usersAndProducts();


    }

    private void usersAndProducts() throws IOException {

        UserCountDto userCountDtos = this.userService.findAllUsersAndTheirSoldProducts();

        String json = this.gson.toJson(userCountDtos);

        this.fileUtil
                .write(json, GlobalConstants.EXERCISE_FOUR_OUTPUT);

    }

    private void categoriesByCount() throws IOException {

        System.out.println();
        List<CategoriesProductsDto> cpDtos = this.categoryService.categoriesByProductsCount();

        String json = this.gson
                .toJson(cpDtos);

        this.fileUtil
                .write(json, GlobalConstants.EXERCISE_THREE_OUTPUT);
    }

    private void getAllUsersWithAtLEastOneProductSold() throws IOException {
        List<UserSoldProductsDto> suerDtos = this.userService.getAllUsersWithAtLeastOneItemSold();

        String json = this.gson.toJson(suerDtos);

        this.fileUtil
                .write(json, GlobalConstants.EXERCISE_TWO_OUTPUT);

    }

    private void writeProductInRange() throws IOException {

        List<ProductInRangeDto> productInRangeDtos = this.productService
                .getAllProductsInRange();

        String json = this.gson.toJson(productInRangeDtos);



        this.fileUtil
                .write(json, GlobalConstants.EXERCISE_ONE_OUTPUT);



    }

    private void seedProducts() throws FileNotFoundException {
        ProductSeedDto[] productSeedDtos = this.gson
                .fromJson(new FileReader(GlobalConstants.PRODUCTS_FILE_PATH),
                        ProductSeedDto[].class);



        this.productService.seedProducts(productSeedDtos);
    }

    private void seedUsers() throws FileNotFoundException {
        UserSeedDto[] userDtos = this.gson
                .fromJson(new FileReader(GlobalConstants.USERS_FILE_PATH),
                        UserSeedDto[].class);

        System.out.println();

        this.userService.seedUsers(userDtos);
    }

    private void seedCategories() throws FileNotFoundException {
        CategorySeedDto[] dtos = this.gson
                .fromJson(new FileReader(GlobalConstants.CATEGORIES_FILE_PATH),
                        CategorySeedDto[].class);


        this.categoryService.seedCategories(dtos);
    }
}
