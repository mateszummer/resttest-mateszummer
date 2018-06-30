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

    public List<Item> getItemList() {
        return itemList;
    }

    @ManyToMany(mappedBy = "categoriesForPub")
    private List<Pub> pubsForCategorie;

    @OneToMany
    private transient List<Item> itemList = new ArrayList<Item>();

    public Category(String name) {
        this.name = name;
    }

    public void addDrinkToCategory(Item item) {
        itemList.add(item);
    }

    public void removeDrinkFromCategory(Item item) {
        itemList.remove(item);}

    public Category() {
    }
}
