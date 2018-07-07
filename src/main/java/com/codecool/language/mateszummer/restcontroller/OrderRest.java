package com.codecool.language.mateszummer.restcontroller;


import com.codecool.language.mateszummer.model.Item;
import com.codecool.language.mateszummer.model.Order;
import com.codecool.language.mateszummer.service.OrderService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static Logger logger = LoggerFactory.getLogger(OrderRest.class);

    @RequestMapping(value= "/addOrder", method = RequestMethod.POST)
    public String addOrder(@RequestParam("orderdetails") String orderdetails){
        logger.error("error here fuck you" + orderdetails);
        logger.info("arrive at server " + orderdetails);
        Gson gson = new Gson();
        HashMap<String, String> jsonParams = gson.fromJson(orderdetails, HashMap.class);
        if (orderService.addOrder(jsonParams)) {
            logger.info("jsonstring " + jsonParams.toString());
            return "ok";
        }
        return "not ok";
    }
}
