package com.codecool.language.mateszummer.repository;

import com.codecool.language.mateszummer.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Category getAllByNameEquals(String type);

}
