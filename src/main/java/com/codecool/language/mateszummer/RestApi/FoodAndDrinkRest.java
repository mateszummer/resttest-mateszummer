package com.codecool.language.mateszummer.RestApi;

import com.codecool.language.mateszummer.Service.FoodAndDrinkService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static org.springframework.data.repository.init.ResourceReader.Type.JSON;

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

    @RequestMapping(value = "/sendMessage", method = RequestMethod.GET)
    public void sendMessage() throws IOException {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
                    OkHttpClient client = new OkHttpClient();
                    JSONObject json=new JSONObject();
                    JSONObject dataJson=new JSONObject();
                    dataJson.put("body","Hi this is sent from device to device");
                    dataJson.put("title","dummy title");
                    json.put("notification",dataJson);
                    json.put("to","f_ZgIqUwglI:APA91bFppEL11qSFapGRUEKLngBXb4BSwfPbcp7blT3YRrQix5yra2pb2bV908L_uECbMK78cV-V8P54nTydZH1NzSPVZykco2IRjvwzaveFm9w6zqyBAzWHOYkFKopxSnA1Xtzcpucb");
                    com.squareup.okhttp.RequestBody body = com.squareup.okhttp.RequestBody.create(JSON,json.toString());
                    Request request = new Request.Builder()
                            .header("Authorization","key=AIzaSyA5XKkKce9Ley9Ih0vak4CkHxvVQKBXpaI")
                            .url("https://fcm.googleapis.com/fcm/send")
                            .post(body)
                            .build();
        client.newCall(request).execute();
    }
}
