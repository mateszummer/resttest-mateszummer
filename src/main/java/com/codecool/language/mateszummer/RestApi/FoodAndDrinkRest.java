package com.codecool.language.mateszummer.RestApi;

import com.codecool.language.mateszummer.Service.FoodAndDrinkService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class FoodAndDrinkRest {

    @Autowired
    FoodAndDrinkService foodAndDrinkService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAll() {
        Gson gson = new Gson();
        return gson.toJson(foodAndDrinkService.getAll());
    }

    @RequestMapping(value = "/addFoodAndDrink", method = RequestMethod.POST)
    public void addFoodAndDrink(@RequestParam("name") String name,
                                @RequestParam("price") Integer price) {
        foodAndDrinkService.addFoodAndDrink(name, price);
    }
}
