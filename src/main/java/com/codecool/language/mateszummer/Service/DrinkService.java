package com.codecool.language.mateszummer.Service;

import com.codecool.language.mateszummer.Repository.DrinkRepo;
import com.codecool.language.mateszummer.model.Drink;
import com.codecool.language.mateszummer.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkService {

    @Autowired
    DrinkRepo drinkRepo;

    public Drink getDrinkById(Integer id) {
        return drinkRepo.getOne(id);
    }

    public List getAll() {
        return drinkRepo.findAll();
    }

    public void addDrink(String name, Integer price, Category category) {
        drinkRepo.save(new Drink(name,price, category));
    }

    public Drink getDrinkByName(String name) {
        return drinkRepo.getDrinksByNameEquals(name);
    }

    public void deleteDrinkByName(String name) {
        Drink drink = getDrinkByName(name);
        drink.getCategory().removeDrinkFromCategory(drink);
        drinkRepo.delete(drink);
    }

    public List<Drink> getAllByCategory(Category category) {
        return drinkRepo.getAllByCategoryEquals(category);
    }
}
