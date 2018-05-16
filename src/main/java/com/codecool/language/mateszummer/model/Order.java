package com.codecool.language.mateszummer.model;


import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Map<Integer, Integer> getOrderMap() {
        return orderMap;
    }

    public void setOrderMap(Map<Integer, Integer> orderMap) {
        this.orderMap = orderMap;
    }

    String orderDate;

    public Order(HashMap<Integer,Integer> order) {
        orderMap = order;
        SimpleDateFormat dateFormatter = new SimpleDateFormat("E, y-M-d 'at' h:m:s a z");
        orderDate = dateFormatter.format("now");
    }

    public Order(){
    }

    @OneToMany
    @ElementCollection
    private transient Map<Integer,Integer> orderMap = new HashMap<Integer, Integer>();


}
