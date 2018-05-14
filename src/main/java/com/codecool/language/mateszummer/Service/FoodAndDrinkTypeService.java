package com.codecool.language.mateszummer.Service;


import com.codecool.language.mateszummer.Repository.FoodAndDrinkTypeRepo;
import com.codecool.language.mateszummer.model.FoodAndDrinkType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodAndDrinkTypeService {

    @Autowired
    FoodAndDrinkTypeRepo foodAndDrinkTypeRepo;

    public List<FoodAndDrinkType> getAll() {
        return foodAndDrinkTypeRepo.findAll();
    }

    public FoodAndDrinkType searchTypeByName(String type) {
        return foodAndDrinkTypeRepo.getFoodAndDrinkTypeByTypeEquals(type);
    }

    public void addFoodAndDrinkType(String name) {
        foodAndDrinkTypeRepo.save(new FoodAndDrinkType(name));
    }

    public void deleteFoodAndDrinkTypeByName(String name) {
        foodAndDrinkTypeRepo.delete(searchTypeByName(name));
    }
}
