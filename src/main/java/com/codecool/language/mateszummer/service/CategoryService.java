package com.codecool.language.mateszummer.service;


import com.codecool.language.mateszummer.repository.CategoryRepository;
import com.codecool.language.mateszummer.repository.DrinkRepository;
import com.codecool.language.mateszummer.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepo;

    @Autowired
    DrinkRepository drinkRepository;

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
        drinkRepository.delete(category.getItemList());
        categoryRepo.delete(category);

    }
}
