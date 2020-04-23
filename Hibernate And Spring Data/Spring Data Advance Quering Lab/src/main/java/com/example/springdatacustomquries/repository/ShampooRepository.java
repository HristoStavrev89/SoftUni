package com.example.springdatacustomquries.repository;

import com.example.springdatacustomquries.entities.Ingredient;
import com.example.springdatacustomquries.entities.Shampoo;
import com.example.springdatacustomquries.enums.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {

    List<Shampoo> findBySize(Size size);

    List<Shampoo> findAllBySizeOrLabelIdOrderByPriceAsc(Size size, long id);

    List<Shampoo> findAllByPriceIsGreaterThanOrderByPriceDesc(double price);

    @Query("SELECT s FROM Shampoo s JOIN s.ingredients i WHERE i IN :ingredients")
    List<Shampoo> findWithIngredientsInList(@Param("ingredients") Iterable<Ingredient> ingredients);

    int countShampooByPriceIsLessThan(double price);

    @Query("SELECT s FROM Shampoo s WHERE s.ingredients.size < :count")
    List<Shampoo> selectShampoosByIngredientCount(@Param("count") int count);
}
