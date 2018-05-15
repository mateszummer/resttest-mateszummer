package com.codecool.language.mateszummer.Repository;

import com.codecool.language.mateszummer.model.Drink;
import com.codecool.language.mateszummer.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrinksRepo extends JpaRepository<Drink, Integer>{

    Drink getDrinksByNameEquals(String name);

    List<Drink> getAllByCategoryEquals(Category category);
}
