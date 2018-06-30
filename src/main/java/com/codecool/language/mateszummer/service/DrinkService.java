package com.codecool.language.mateszummer.service;

import com.codecool.language.mateszummer.model.Item;
import com.codecool.language.mateszummer.repository.DrinkRepository;
import com.codecool.language.mateszummer.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkService {

    @Autowired
    DrinkRepository drinkRepository;

    public Item getDrinkById(Integer id) {
        return drinkRepository.getOne(id);
    }

    public List getAll() {
        return drinkRepository.findAll();
    }

    public void addDrink(String name, Integer price, Category category) {
        drinkRepository.save(new Item(name,price, category));
    }

    public Item getDrinkByName(String name) {
        return drinkRepository.getDrinksByNameEquals(name);
    }

    public void deleteDrinkByName(String name) {
        Item item = getDrinkByName(name);
        item.getCategory().removeDrinkFromCategory(item);
        drinkRepository.delete(item);
    }

    public List<Item> getAllByCategory(Category category) {
        return drinkRepository.getAllByCategoryEquals(category);
    }
}
