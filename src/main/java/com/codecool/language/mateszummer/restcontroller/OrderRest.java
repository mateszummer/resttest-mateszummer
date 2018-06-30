package com.codecool.language.mateszummer.restcontroller;


import com.codecool.language.mateszummer.model.Item;
import com.codecool.language.mateszummer.model.Order;
import com.codecool.language.mateszummer.service.OrderService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class OrderRest {

    @Autowired
    OrderService orderService;

    @RequestMapping(value= "/addOrder", method = RequestMethod.POST)
    public String addOrder(@RequestParam("params") HashMap<String,String> params){
        ArrayList items = new ArrayList<Item>();
        Gson gson = new Gson();
        HashMap<String, String> jsonParams = gson.fromJson(params.get("orderdetails"), HashMap.class);
        if (orderService.addOrder(jsonParams)) {
            return "ok";
        }
        return "not ok";
    }

}
