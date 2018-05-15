package com.codecool.language.mateszummer.Service;

import com.codecool.language.mateszummer.Repository.DrinksRepo;
import com.codecool.language.mateszummer.model.Drinks;
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
        drinksRepo.save(new Drinks(name,price, category));
    }

    public Drinks getDrinkByName(String name) {
        return drinksRepo.getDrinksByNameEquals(name);
    }

    public void deleteDrinkByName(String name) {
        drinksRepo.delete(getDrinkByName(name));
    }

    public List<Drinks> getAllByCategory(Category category) {
        return drinksRepo.getAllByCategoryEquals(category);
    }
}
