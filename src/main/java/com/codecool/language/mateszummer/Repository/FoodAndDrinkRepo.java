package com.codecool.language.mateszummer.Repository;

import com.codecool.language.mateszummer.model.FoodAndDrink;
import com.codecool.language.mateszummer.model.FoodAndDrinkType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodAndDrinkRepo extends JpaRepository<FoodAndDrink, Integer>{

    FoodAndDrink getFoodAndDrinkByNameEquals(String name);

    List<FoodAndDrink> getAllByFoodAndFoodAndDrinkTypeEquals(FoodAndDrinkType foodAndDrinkType);
}
