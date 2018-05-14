package com.codecool.language.mateszummer.model;

import javax.persistence.*;

//Beer, Shot, Wine, Soft drink, Coffee.


@Entity
public class FoodAndDrink {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private Integer price;

    @OneToMany
    private FoodAndDrinkType foodAndDrinkType;


    public FoodAndDrink() {
    }

    public FoodAndDrink(String name, Integer price, FoodAndDrinkType foodAndDrinkType) {
        this.name = name;
        this.price = price;
        this.foodAndDrinkType = foodAndDrinkType;
    }

    public Integer getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
