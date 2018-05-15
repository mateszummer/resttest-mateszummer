package com.codecool.language.mateszummer.Repository;

import com.codecool.language.mateszummer.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

    Category getAllByNameEquals(String type);
}
