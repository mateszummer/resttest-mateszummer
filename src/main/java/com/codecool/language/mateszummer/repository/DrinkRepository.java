package com.codecool.language.mateszummer.repository;

import com.codecool.language.mateszummer.model.Drink;
import com.codecool.language.mateszummer.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrinkRepository extends JpaRepository<Drink, Integer>{

    Drink getDrinksByNameEquals(String name);

    List<Drink> getAllByCategoryEquals(Category category);
}
