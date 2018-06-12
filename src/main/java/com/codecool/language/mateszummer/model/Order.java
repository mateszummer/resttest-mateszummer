package com.codecool.language.mateszummer.model;


import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
@Table(name = "Order")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String billDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBill() {
        return billDate;
    }

    public void setBillDate(String orderDate) {
        this.billDate = orderDate;
    }

//    public Map<Drink, Integer> getOrderMap() {
//        return orderMap;
//    }
//
//    public void setOrderMap(Map<Drink, Integer> orderMap) {
//        this.orderMap = orderMap;
//    }


//    public Order(HashMap<Drink,Integer> order) {
//        orderMap = order;
//        SimpleDateFormat dateFormatter = new SimpleDateFormat("E, y-M-d 'at' h:m:s a z");
//        orderDate = dateFormatter.format("now");
//    }

    public Order(){
    }


//    private Map<Drink,Integer> orderMap = new HashMap<>();


}
