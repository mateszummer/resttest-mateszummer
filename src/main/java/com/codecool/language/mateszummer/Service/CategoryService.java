package com.codecool.language.mateszummer.Service;


import com.codecool.language.mateszummer.Repository.CategoryRepo;
import com.codecool.language.mateszummer.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    public List<Category> getAll() {
        return categoryRepo.findAll();
    }

    public Category getCategoryByName(String type) {
        return categoryRepo.getAllByNameEquals(type);
    }

    public void addCategory(String name) {
        categoryRepo.save(new Category(name));
    }

    public void deleteItemByName(String name){
        categoryRepo.delete(getCategoryByName(name));
    }
}
