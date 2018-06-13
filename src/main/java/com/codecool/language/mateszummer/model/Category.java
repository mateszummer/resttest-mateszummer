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

    public List<Drink> getDrinkList() {
        return drinkList;
    }

    @ManyToMany(mappedBy = "categoriesForPub")
    private List<Pub> pubsForCategorie;

    @OneToMany
    private transient List<Drink> drinkList = new ArrayList<Drink>();

    public Category(String name) {
        this.name = name;
    }

    public void addDrinkToCategory(Drink drink) {
        drinkList.add(drink);
    }

    public void removeDrinkFromCategory(Drink drink) {drinkList.remove(drink);}

    public Category() {
    }
}
