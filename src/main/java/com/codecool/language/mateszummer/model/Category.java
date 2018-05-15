package com.codecool.language.mateszummer.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToMany
    private transient List<Drinks> drinksList = new ArrayList<Drinks>();

    public Category(String name) {
        this.name = name;
    }

    public void addFoodAndDrink(Drinks drinks) {
        drinksList.add(drinks);
    }

    public Category() {
    }
}
