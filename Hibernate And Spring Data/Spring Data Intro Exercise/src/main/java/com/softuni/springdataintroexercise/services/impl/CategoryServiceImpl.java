package com.softuni.springdataintroexercise.services.impl;

import com.softuni.springdataintroexercise.constants.GlobalConstants;
import com.softuni.springdataintroexercise.entities.Category;
import com.softuni.springdataintroexercise.repositories.CategoryRepository;
import com.softuni.springdataintroexercise.services.CategoryService;
import com.softuni.springdataintroexercise.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final FileUtil fileUtil;


    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, FileUtil fileUtil) {
        this.categoryRepository = categoryRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedCategories() throws IOException {
        //todo da se opravi
        if (this.categoryRepository.count() != 0) {
            return;
        }

        String[] fileContent = this.fileUtil
                .readFileContent(GlobalConstants.CATEGORIES_FILE_PATH);


        Arrays.stream(fileContent)
                .forEach(r -> {
                    Category category = new Category(r);

                    this.categoryRepository.saveAndFlush(category);
                });


    }

    @Override
    public Category getCategoryById(Long id) {
       return this.categoryRepository.getOne(id);
    }

    @Override
    public Set<Category> getRandomCategories() {
        Set<Category> result = new HashSet<>();

        Random random = new Random();

        int bound = random.nextInt(3) + 1;


        for (int i = 1; i <= bound; i++) {
            int categoryId = random.nextInt(8) + 1;
            result.add(getCategoryById((long) categoryId));
        }
        return result;
    }


}
