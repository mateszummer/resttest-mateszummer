package com.codecool.language.mateszummer.repository;

import com.codecool.language.mateszummer.model.Item;
import com.codecool.language.mateszummer.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrinkRepository extends JpaRepository<Item, Integer>{

    Item getDrinksByNameEquals(String name);

    List<Item> getAllByCategoryEquals(Category category);
}
