package com.codecool.language.mateszummer.Service;

import com.codecool.language.mateszummer.Repository.OrderRepo;
import com.codecool.language.mateszummer.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;


    public List getAll() {
        return orderRepo.findAll();
    }


    public void addOrder(HashMap<String,HashMap> orderMap) {
        orderRepo.save(new Order(orderMap));
    }
}
