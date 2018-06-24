package com.codecool.language.mateszummer.Repository;

import com.codecool.language.mateszummer.model.Item;
import com.codecool.language.mateszummer.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepo extends JpaRepository<Item, Integer>{

    Item getItemsByNameEquals(String name);

    List<Item> getAllByCategoryEquals(Category category);
}
