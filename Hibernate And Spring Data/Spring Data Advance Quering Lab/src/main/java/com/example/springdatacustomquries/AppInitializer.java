package com.example.springdatacustomquries;

import com.example.springdatacustomquries.entities.Ingredient;
import com.example.springdatacustomquries.enums.Size;
import com.example.springdatacustomquries.repository.IngredientRepository;
import com.example.springdatacustomquries.repository.LabelRepository;
import com.example.springdatacustomquries.repository.ShampooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppInitializer implements ApplicationRunner {
    private final ShampooRepository shampooRepository;
    private final LabelRepository labelRepository;
    private final IngredientRepository ingredientRepository;

    @Autowired
    public AppInitializer(ShampooRepository shampooRepository, LabelRepository labelRepository, IngredientRepository ingredientRepository) {
        this.shampooRepository = shampooRepository;
        this.labelRepository = labelRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //Task 1 - Select shampoos by size
        //selectShampoosBySize();

        //Task 2 - Select shampoos by size and label
        //selectShampoosBySizeOrLabel();

        //Task 3 - Select shampoos by price
        //selectShampoosByPrice();

        //Task 4 - Select ingredients by name, where the name starts with...
        //selectIngredientsByName();

        //Task 5 Select ingredients by names
        //selectIngredientsByNames();

        //Task 6 Count Shampoos by Price
        //countShampoosByPrice();

        //Task 7 Select Shampoos by ingredients(List)
        //findShampoosWithGivenIngredientsList();

        //Task 8 Select all Shampoos by ingredients count
        //selectAllShampoosByIngredientsCount();

        //Task 9 Delete Ingredients by name
        //deleteIngredientsByName();

    }

    private void deleteIngredientsByName() {
        System.out.println("Before update");
        this.ingredientRepository
                .findByNameInOrderByPrice(List.of("Lavender", "Herbs", "Apple"))
                .forEach(i -> System.out.printf("%d %s %.2f%n", i.getId(), i.getName(), i.getPrice()));
        //Update
        this.ingredientRepository
                .updateIngredientsPriceInListBy10Percent(List.of("Lavender", "Herbs", "Apple"));
        //After update
        System.out.println("After update");
        this.ingredientRepository
                .findByNameInOrderByPrice(List.of("Lavender", "Herbs", "Apple"))
                .forEach(i -> System.out.printf("%d %s %.2f%n", i.getId(), i.getName(), i.getPrice()));

    }

    private void selectAllShampoosByIngredientsCount() {
        this.shampooRepository
                .selectShampoosByIngredientCount(2)
                .forEach(s -> System.out.printf("%s%n", s.getBrand()));
    }

    private void countShampoosByPrice() {
        int countOfShampoos = this.shampooRepository
                .countShampooByPriceIsLessThan(8.50);
        System.out.println(countOfShampoos);
    }

    private void selectIngredientsByNames() {
        this.ingredientRepository
                .findByNameInOrderByPrice(List.of("Lavender", "Herbs", "Apple"))
                .forEach(i -> System.out.printf("%d %s %.2f%n", i.getId(), i.getName(), i.getPrice()));
    }

    private void findShampoosWithGivenIngredientsList() {


        this.shampooRepository
                .findWithIngredientsInList(List.of(this.ingredientRepository.findByName("Berry"), this.ingredientRepository.findByName("Mineral-Collagen")))
                .forEach(s -> System.out.printf("%s %s %.2f %n"
                        , s.getBrand()
                        , s.getSize()
                        , s.getPrice()
                ));

    }

    private void selectIngredientsByName() {
        this.ingredientRepository
                .selectIngredientsStartsWithLetter("M")
                .forEach(i -> System.out.printf("%s%n", i.getName()));
    }

    private void selectShampoosByPrice() {
        this.shampooRepository
                .findAllByPriceIsGreaterThanOrderByPriceDesc(5)
                .forEach(s -> System.out.printf("%s %s %.2flv.%n"
                        , s.getBrand()
                        , s.getSize()
                        , s.getPrice()
                ));
    }

    private void selectShampoosBySizeOrLabel() {
        this.shampooRepository
                .findAllBySizeOrLabelIdOrderByPriceAsc(Size.MEDIUM, 10)
                .forEach(s -> System.out.printf("%s %s %.2flv.%n"
                        , s.getBrand()
                        , s.getSize()
                        , s.getPrice()
                ));
    }

    private void selectShampoosBySize() {
        this.shampooRepository
                .findBySize(Size.MEDIUM)
                .forEach(s -> System.out.printf("%s %s %s %.2flv.%n"
                        , s.getBrand()
                        , s.getSize()
                        , s.getLabel().getTitle()
                        , s.getPrice()));
    }


}
