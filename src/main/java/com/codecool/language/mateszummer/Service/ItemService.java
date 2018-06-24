package com.codecool.language.mateszummer.Service;

import com.codecool.language.mateszummer.Repository.ItemRepo;
import com.codecool.language.mateszummer.model.Item;
import com.codecool.language.mateszummer.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepo itemRepo;

    public List getAll() {
        return itemRepo.findAll();
    }

    public void addDrink(String name, Integer price, Category category) {
        itemRepo.save(new Item(name,price, category));
    }

    public Item getDrinkByName(String name) {
        return itemRepo.getItemsByNameEquals(name);
    }

    public void deleteItemByName(String name) {
        itemRepo.delete(getDrinkByName(name));
    }

    public List<Item> getAllByCategory(Category category) {
        return itemRepo.getAllByCategoryEquals(category);
    }
}
