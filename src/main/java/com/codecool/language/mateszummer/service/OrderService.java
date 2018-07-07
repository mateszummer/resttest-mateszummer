package com.codecool.language.mateszummer.service;

import com.codecool.language.mateszummer.model.Item;
import com.codecool.language.mateszummer.model.Order;
import com.codecool.language.mateszummer.repository.OrderRepository;
import com.google.gson.Gson;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {

    @Autowired
    DrinkService drinkService;

    @Autowired
    OrderRepository orderRepository;

    private static Logger logger = LoggerFactory.getLogger(OrderService.class);

    public List getAll() {
        return orderRepository.findAll();
    }

    public boolean addOrder(HashMap<String, String> jsonParams) {
        Gson gson = new Gson();
        Order order = new Order();
        for (Map.Entry<String, String> entry : jsonParams.entrySet()) {
            logger.info("entry set in service " + jsonParams.entrySet().toString());
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
