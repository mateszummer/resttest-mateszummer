package com.codecool.language.mateszummer.model;

import javax.persistence.*;

//Beer, Shot, Wine, Soft drink, Coffee.


@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private Integer price;


    @ManyToOne
    private Category category;

    @ManyToOne
    private Pub pub;

    @ManyToOne
    private Order order;

    public Item() {
    }

    public Item(String name, Integer price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
        category.addDrinkToCategory(this);
    }

    public Category getCategory() {
        return category;
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

    public Pub getPub() {
        return pub;
    }

    public void setPub(Pub pub) {
        this.pub = pub;
    }


}
