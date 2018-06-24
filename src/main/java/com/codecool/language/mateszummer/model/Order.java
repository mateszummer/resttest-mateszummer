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

    public Map<String, HashMap> getOrderMap() {
        return orderMap;
    }

    public void setOrderMap(Map<String, HashMap> orderMap) {
        this.orderMap = orderMap;
    }

    String orderDate;



    public Order(HashMap<String,HashMap> order) {
        orderMap = order;
        SimpleDateFormat dateFormatter = new SimpleDateFormat("E, y-M-d 'at' h:m:s a z");
        orderDate = dateFormatter.format("now");
    }

    public Order(){
    }

    @OneToMany
    @ElementCollection
    private transient Map<String,HashMap> orderMap = new HashMap<String,HashMap>();


}
