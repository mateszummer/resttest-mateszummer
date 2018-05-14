package com.codecool.language.mateszummer.Repository;

import com.codecool.language.mateszummer.model.FoodAndDrinkType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodAndDrinkTypeRepo extends JpaRepository<FoodAndDrinkType, Integer> {

    FoodAndDrinkType getFoodAndDrinkTypeByTypeEquals(String type);
}
