package com.codecool.language.mateszummer.RestApi;

import com.codecool.language.mateszummer.Service.FoodAndDrinkService;
import com.codecool.language.mateszummer.Service.FoodAndDrinkTypeService;
import com.codecool.language.mateszummer.model.FoodAndDrinkType;
import com.google.gson.Gson;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class FoodAndDrinkRest {

    @Value("androidKey")
    String androidKey;

    @Value("firebaseSrvKey")
    String firebaseSrvKey;

    @Autowired
    FoodAndDrinkService foodAndDrinkService;
    @Autowired
    FoodAndDrinkTypeService foodAndDrinkTypeService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAll() {
        Gson gson = new Gson();
        return gson.toJson(foodAndDrinkService.getAll());
    }

    @RequestMapping(value = "/getFoodAndDrinkByType/{type}", method = RequestMethod.GET)
    public String getFoodAndDrinkByType(@PathVariable("type") String type) {
        FoodAndDrinkType foodAndDrinkType = foodAndDrinkTypeService.searchTypeByName(type);
        Gson gson = new Gson();
        return gson.toJson(foodAndDrinkService.getAllByType(foodAndDrinkType));
    }

    @RequestMapping(value = "/getTypes", method = RequestMethod.GET)
    public String getType() {
        Gson gson = new Gson();
        return gson.toJson(foodAndDrinkTypeService.getAll());
    }

    @RequestMapping(value = "/deleteFoodAndDrink", method = RequestMethod.POST)
    public void deleteFoodAndDrink(@RequestParam("name") String name) {
        foodAndDrinkService.deleteFoodAndDrinkByName(name);
    }

    @RequestMapping(value = "/deleteType", method = RequestMethod.POST)
    public void deleteType(@RequestParam("Type") String type) {
        foodAndDrinkTypeService.deleteFoodAndDrinkTypeByName(type);
    }

    @RequestMapping(value = "/addFoodAndDrink", method = RequestMethod.POST)
    public void addFoodAndDrink(@RequestParam("name") String name,
                                @RequestParam("price") Integer price,
                                @RequestParam("Type") String foodAndDrinkTypeName) {
        FoodAndDrinkType foodAndDrinkType = foodAndDrinkTypeService.searchTypeByName(foodAndDrinkTypeName);
        if (foodAndDrinkType == null) {
            foodAndDrinkTypeService.addFoodAndDrinkType(foodAndDrinkTypeName);
            foodAndDrinkType = foodAndDrinkTypeService.searchTypeByName(foodAndDrinkTypeName);
        }
        foodAndDrinkService.addFoodAndDrink(name, price,foodAndDrinkType);
    }

    @RequestMapping(value = "/sendMessage/{msg}", method = RequestMethod.GET)
    public void sendMessage(@PathVariable("msg") String msg) throws IOException {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
                    OkHttpClient client = new OkHttpClient();
                    JSONObject json=new JSONObject();
                    JSONObject dataJson=new JSONObject();
                    dataJson.put("body",msg);
                    dataJson.put("title","random title");
                    json.put("notification",dataJson);
                    json.put("to",androidKey);
                    com.squareup.okhttp.RequestBody body = com.squareup.okhttp.RequestBody.create(JSON,json.toString());
                    Request request = new Request.Builder()
                            .header("Authorization",firebaseSrvKey)
                            .url("https://fcm.googleapis.com/fcm/send")
                            .post(body)
                            .build();
        client.newCall(request).execute();
    }
}
