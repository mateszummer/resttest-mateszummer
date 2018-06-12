package com.codecool.language.mateszummer.service;

import com.codecool.language.mateszummer.repository.OrderRepository;
import com.codecool.language.mateszummer.model.Drink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    @Autowired
    DrinkService drinkService;

    @Autowired
    OrderRepository orderRepository;


    public List getAll() {
        return orderRepository.findAll();
    }


    public void addOrder(HashMap<Integer,Integer> orderMap) {
        HashMap<Drink, Integer> orderMapWithDrink = new HashMap<>();
        Iterator it = orderMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            Drink drink = drinkService.getDrinkById((Integer) pair.getKey());
            orderMapWithDrink.put(drink, (Integer) pair.getValue());

        }
        //orderRepository.save(new Order(orderMapWithDrink));
    }
}
