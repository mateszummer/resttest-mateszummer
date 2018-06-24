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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getDrinksList() {
        return drinksList;
    }

    public void setDrinksList(List<Item> drinksList) {
        this.drinksList = drinksList;
    }

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    @OneToMany
    private transient List<Item> drinksList = new ArrayList<Item>();

    public void addFoodAndDrink(Item drinks) {
        drinksList.add(drinks);
    }

}
