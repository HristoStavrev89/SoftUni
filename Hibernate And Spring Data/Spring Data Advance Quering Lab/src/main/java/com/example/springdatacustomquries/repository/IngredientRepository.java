package com.example.springdatacustomquries.repository;

import com.example.springdatacustomquries.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {


    @Query("SELECT i FROM Ingredient AS i WHERE i.name LIKE :nameStartWith" + "%")
    List<Ingredient> selectIngredientsStartsWithLetter(@Param("nameStartWith") String letter);

    Ingredient findByName(String name);

    List<Ingredient> findByNameInOrderByPrice(Iterable<String> ingredientsNames);

    @Modifying
    @Transactional
    @Query("UPDATE Ingredient AS i SET i.price = i.price * 1.10 WHERE i.name IN :names")
    int updateIngredientsPriceInListBy10Percent(@Param("names")Iterable<String> names);



}
