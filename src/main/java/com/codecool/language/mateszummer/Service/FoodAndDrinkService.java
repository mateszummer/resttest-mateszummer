package com.codecool.language.mateszummer.Service;

import com.codecool.language.mateszummer.Repository.FoodAndDrinkRepo;
import com.codecool.language.mateszummer.model.FoodAndDrink;
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

    public void addFoodAndDrink(String name, Integer price) {
        foodAndDrinkRepo.save(new FoodAndDrink(name,price));
    }
}
