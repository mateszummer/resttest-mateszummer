package com.codecool.language.mateszummer.model;


import javax.persistence.*;
import java.util.*;

@Entity
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @OneToMany
    @Column
    private List<Item> items;

    @Column(name = "ORDER_DATE")
    private Date orderDate;



    public Order() {
        this.items = new ArrayList<Item>();
        orderDate= new Date();
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Date getOrderDate() {
        return orderDate;
    }


    public List<Item> getItems() {
        return items;
    }

    public void addtoItems(Item item) {
        items.add(item);
    }

}
