package com.codecool.language.mateszummer.model;

import javax.persistence.*;

//Beer, Shot, Wine, Soft drink, Coffee.


@Entity
public class Drinks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private Integer price;

    @ManyToOne
    private Category category;


    public Drinks() {
    }

    public Drinks(String name, Integer price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
        category.addFoodAndDrink(this);
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
