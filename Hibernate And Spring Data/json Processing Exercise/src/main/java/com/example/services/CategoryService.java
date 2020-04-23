package com.example.services;


import com.example.demo.models.dtos.CategorySeedDto;
import com.example.demo.models.dtos.exercise2.CategoriesProductsDto;
import com.example.demo.models.entities.Category;

import java.util.List;

public interface CategoryService {

    void seedCategories(CategorySeedDto[] categorySeedDto);



    List<Category> getRandomCategories();


    List<CategoriesProductsDto> categoriesByProductsCount();


}
