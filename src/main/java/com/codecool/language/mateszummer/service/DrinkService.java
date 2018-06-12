package com.codecool.language.mateszummer.service;

import com.codecool.language.mateszummer.repository.DrinkRepository;
import com.codecool.language.mateszummer.model.Drink;
import com.codecool.language.mateszummer.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkService {

    @Autowired
    DrinkRepository drinkRepository;

    public Drink getDrinkById(Integer id) {
        return drinkRepository.getOne(id);
    }

    public List getAll() {
        return drinkRepository.findAll();
    }

    public void addDrink(String name, Integer price, Category category) {
        drinkRepository.save(new Drink(name,price, category));
    }

    public Drink getDrinkByName(String name) {
        return drinkRepository.getDrinksByNameEquals(name);
    }

    public void deleteDrinkByName(String name) {
        Drink drink = getDrinkByName(name);
        drink.getCategory().removeDrinkFromCategory(drink);
        drinkRepository.delete(drink);
    }

    public List<Drink> getAllByCategory(Category category) {
        return drinkRepository.getAllByCategoryEquals(category);
    }
}
