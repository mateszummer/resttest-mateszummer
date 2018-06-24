package com.codecool.language.mateszummer.RestApi;

import com.codecool.language.mateszummer.Service.ItemService;
import com.codecool.language.mateszummer.Service.CategoryService;
import com.codecool.language.mateszummer.Service.OrderService;
import com.codecool.language.mateszummer.model.Category;
import com.google.gson.Gson;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;

@RestController
public class ItemRest {

    @Value("androidKey")
    String androidKey;

    @Value("firebaseSrvKey")
    String firebaseSrvKey;

    @Autowired
    ItemService itemService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    OrderService orderService;

    @RequestMapping(value= "/addOrder", method = RequestMethod.POST)
    public String addOrder(@RequestParam("orderMap") HashMap<String,HashMap> orderMap){
        //orderService.addOrder(orderMap);
        Gson gson = new Gson();
        return gson.toJson("ok");
    }

    @PostMapping(value = "/addCategory")
    public void addCategory(@RequestParam("categoryName") String categoryName){
        categoryService.addCategory(categoryName);
    }

    @GetMapping(value = "/getAllOrder")
    public String getAllOrder(){
        Gson gson = new Gson();
        return gson.toJson(orderService.getAll());
    }


    @GetMapping(value = "/getAll")
    public String getAll() {
        Gson gson = new Gson();
        return gson.toJson(itemService.getAll());
    }

    @GetMapping(value = "/getDrinksByCategory/{category}")
    public String getFoodAndDrinkByType(@PathVariable("category") String inCategory) {
        Category category = categoryService.getCategoryByName(inCategory);
        Gson gson = new Gson();
        return gson.toJson(itemService.getAllByCategory(category));
    }

    @GetMapping(value = "/getCategories")
    public String getType() {
        Gson gson = new Gson();
        return gson.toJson(categoryService.getAll());
    }

    @PostMapping(value = "/deleteDrink")
    public void deleteFoodAndDrink(@RequestParam("name") String name) {
        itemService.deleteItemByName(name);
    }

    @PostMapping(value = "/deleteCategory")
    public void deleteType(@RequestParam("Type") String type) {
        categoryService.deleteItemByName(type);
    }
/*
    @RequestMapping(value = "/addDrink", method = RequestMethod.POST)
    public void addFoodAndDrink(@RequestParam("name") String name,
                                @RequestParam("price") Integer price,
                                @RequestParam("category") String inCategory) {
        Category category = categoryService.getCategoryByName(inCategory);
        if (category == null) {
            categoryService.addCategory(inCategory);
            category = categoryService.getCategoryByName(inCategory);
        }
        itemService.addDrink(name, price, category);
    }*/

    @PostMapping(value = "/addItem")
    public void addFoodAndDrink(@RequestParam("name") String name,
                                @RequestParam("price") Integer price,
                                @RequestParam("category") String category) {
        itemService.addDrink(name, price, categoryService.getCategoryByName(category));
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
