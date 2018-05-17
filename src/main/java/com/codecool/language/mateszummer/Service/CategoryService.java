package com.codecool.language.mateszummer.Service;


import com.codecool.language.mateszummer.Repository.CategoryRepo;
import com.codecool.language.mateszummer.Repository.DrinkRepo;
import com.codecool.language.mateszummer.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    DrinkRepo drinkRepo;

    public List<Category> getAll() {
        return categoryRepo.findAll();
    }

    public Category getCategoryByName(String type) {
        return categoryRepo.getAllByNameEquals(type);
    }

    public void addCategory(String name) {
        categoryRepo.save(new Category(name));
    }

    public void deleteCategoryByName(String name) {
        Category category = getCategoryByName(name);
        drinkRepo.delete(category.getDrinkList());
        categoryRepo.delete(category);

    }
}
