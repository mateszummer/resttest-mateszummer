package com.codecool.language.mateszummer.Service;

import com.codecool.language.mateszummer.Repository.DrinksRepo;
import com.codecool.language.mateszummer.model.Drink;
import com.codecool.language.mateszummer.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinksService {

    @Autowired
    DrinksRepo drinksRepo;

    public List getAll() {
        return drinksRepo.findAll();
    }

    public void addDrink(String name, Integer price, Category category) {
        drinksRepo.save(new Drink(name,price, category));
    }

    public Drink getDrinkByName(String name) {
        return drinksRepo.getDrinksByNameEquals(name);
    }

    public void deleteDrinkByName(String name) {
        Drink drink = getDrinkByName(name);
        drink.getCategory().removeDrinkFromCategory(drink);
        drinksRepo.delete(drink);
    }

    public List<Drink> getAllByCategory(Category category) {
        return drinksRepo.getAllByCategoryEquals(category);
    }
}
