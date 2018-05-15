package com.codecool.language.mateszummer.Repository;

import com.codecool.language.mateszummer.model.Drinks;
import com.codecool.language.mateszummer.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrinksRepo extends JpaRepository<Drinks, Integer>{

    Drinks getDrinksByNameEquals(String name);

    List<Drinks> getAllByCategoryEquals(Category category);
}
