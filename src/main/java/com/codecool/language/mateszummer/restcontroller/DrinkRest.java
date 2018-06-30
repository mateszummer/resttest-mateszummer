package com.codecool.language.mateszummer.restcontroller;

import com.codecool.language.mateszummer.service.DrinkService;
import com.codecool.language.mateszummer.service.CategoryService;
import com.codecool.language.mateszummer.service.OrderService;
import com.codecool.language.mateszummer.model.Category;
import com.codecool.language.mateszummer.model.Item;
import com.codecool.language.mateszummer.model.Order;
import com.google.gson.Gson;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import org.codehaus.jackson.annotate.JsonCreator;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class DrinkRest {

    @Value("androidKey")
    String androidKey;

    @Value("firebaseSrvKey")
    String firebaseSrvKey;

    @Autowired
    DrinkService drinkService;
    @Autowired
    CategoryService categoryService;

    @Autowired
    OrderService orderService;



    @PostMapping(value = "/addCategory")
    public void addCategory(@RequestParam("categoryName") String categoryName){
        categoryService.addCategory(categoryName);
    }


    @RequestMapping(value = "/getAllOrder", method = RequestMethod.GET)
    public String getAllOrder(){
        Gson gson = new Gson();
        return gson.toJson(orderService.getAll());
    }


    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAll() {
        Gson gson = new Gson();
        return gson.toJson(drinkService.getAll());
    }

    @RequestMapping(value = "/getDrinksByCategory/{category}", method = RequestMethod.GET)
    public String getDrinkByCategory(@PathVariable("category") String inCategory) {
        Category category = categoryService.getCategoryByName(inCategory);
        Gson gson = new Gson();
        return gson.toJson(drinkService.getAllByCategory(category));
    }

    @RequestMapping(value = "/get500", method = RequestMethod.GET)
    public ResponseEntity get500() {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/getCategories", method = RequestMethod.GET)
    public String getCategories() {
        Gson gson = new Gson();
        return gson.toJson(categoryService.getAll());
    }

    @RequestMapping(value = "/deleteDrink", method = RequestMethod.POST)
    public void deleteDrink(@RequestParam("name") String name) {
        drinkService.deleteDrinkByName(name);
    }

    @RequestMapping(value = "/deleteCategory", method = RequestMethod.POST)
    public void deleteCategory(@RequestParam("category") String category) {
        categoryService.deleteCategoryByName(category);
    }

    @RequestMapping(value = "/addDrink", method = RequestMethod.POST)
    public void addDrink(@RequestParam("name") String name,
                         @RequestParam("price") Integer price,
                         @RequestParam("category") String inCategory) {
        Category category = categoryService.getCategoryByName(inCategory);
        if (category == null) {
            categoryService.addCategory(inCategory);
            category = categoryService.getCategoryByName(inCategory);
        }
        drinkService.addDrink(name, price, category);
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
