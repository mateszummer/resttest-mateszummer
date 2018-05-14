package com.codecool.language.mateszummer.Service;

import com.codecool.language.mateszummer.Repository.FoodAndDrinkRepo;
import com.codecool.language.mateszummer.model.FoodAndDrink;
import com.codecool.language.mateszummer.model.FoodAndDrinkType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodAndDrinkService {

    @Autowired
    FoodAndDrinkRepo foodAndDrinkRepo;

    public List getAll() {
        return foodAndDrinkRepo.findAll();
    }

    public void addFoodAndDrink(String name, Integer price, FoodAndDrinkType foodAndDrinkType) {
        foodAndDrinkRepo.save(new FoodAndDrink(name,price, foodAndDrinkType));
    }

    public FoodAndDrink getOneByName(String name) {
        return foodAndDrinkRepo.getFoodAndDrinkByNameEquals(name);
    }

    public void deleteFoodAndDrinkByName(String name) {
        foodAndDrinkRepo.delete(getOneByName(name));
    }

    public List<FoodAndDrink> getAllByType(FoodAndDrinkType foodAndDrinkType) {
        return foodAndDrinkRepo.getAllByFoodAndFoodAndDrinkTypeEquals(foodAndDrinkType);
    }
}
