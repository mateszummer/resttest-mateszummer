package com.codecool.language.mateszummer.RestApi;


import com.codecool.language.mateszummer.Service.OrderService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class OrderRest {

//    @Autowired
//    OrderService orderService;
//
//    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
//    public void deleteCategory(@RequestParam("order") HashMap<Integer, Integer> order) {
//        orderService.addOrder(order);
//    }
//
//    @RequestMapping(value = "/getOrders", method = RequestMethod.GET)
//    public String getOrders() {
//        Gson gson = new Gson();
//        return gson.toJson(orderService.getAll());
//    }
}
