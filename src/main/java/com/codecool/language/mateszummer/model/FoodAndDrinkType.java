package com.codecool.language.mateszummer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FoodAndDrinkType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String type;

    public FoodAndDrinkType(String type) {
        this.type = type;
    }

    public FoodAndDrinkType() {
    }
}
