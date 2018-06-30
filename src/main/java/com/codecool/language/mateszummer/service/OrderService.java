package com.codecool.language.mateszummer.service;

import com.codecool.language.mateszummer.model.Item;
import com.codecool.language.mateszummer.model.Order;
import com.codecool.language.mateszummer.repository.OrderRepository;
import com.google.gson.Gson;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {

    @Autowired
    DrinkService drinkService;

    @Autowired
    OrderRepository orderRepository;


    public List getAll() {
        return orderRepository.findAll();
    }

    public boolean addOrder(HashMap<String, String> jsonParams) {
        Gson gson = new Gson();
        Order order = new Order();
        for (Map.Entry<String, String> entry : jsonParams.entrySet()) {
            Integer itemAmount = gson.fromJson(entry.getValue(), Integer.class);
            Item itemToOrder = gson.fromJson(entry.getKey(), Item.class);
            for (int i=0; i<itemAmount; i++) {
                order.addtoItems(itemToOrder);
            }
        }
        orderRepository.save(order);
        if (orderRepository.findAll().contains(order)) {
            return true;
        }
        return false;

    }
}
