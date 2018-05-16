package com.codecool.language.mateszummer.RestApi;

import com.codecool.language.mateszummer.Service.DrinksService;
import com.codecool.language.mateszummer.Service.CategoryService;
import com.codecool.language.mateszummer.model.Category;
import com.google.gson.Gson;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class DrinksRest {

    @Value("androidKey")
    String androidKey;

    @Value("firebaseSrvKey")
    String firebaseSrvKey;

    @Autowired
    DrinksService drinksService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAll() {
        Gson gson = new Gson();
        return gson.toJson(drinksService.getAll());
    }

    @RequestMapping(value = "/getDrinksByCategory/{category}", method = RequestMethod.GET)
    public String getDrinkByCategory(@PathVariable("category") String inCategory) {
        Category category = categoryService.getCategoryByName(inCategory);
        Gson gson = new Gson();
        return gson.toJson(drinksService.getAllByCategory(category));
    }

    @RequestMapping(value = "/get503", method = RequestMethod.GET)
    public ResponseEntity get503() {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/getCategories", method = RequestMethod.GET)
    public String getCategories() {
        Gson gson = new Gson();
        return gson.toJson(categoryService.getAll());
    }

    @RequestMapping(value = "/deleteDrink", method = RequestMethod.POST)
    public void deleteDrink(@RequestParam("name") String name) {
        drinksService.deleteDrinkByName(name);
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
        drinksService.addDrink(name, price, category);
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
