package com.codecool.language.mateszummer.RestApi;

import com.codecool.language.mateszummer.Service.FoodAndDrinkService;
import com.codecool.language.mateszummer.dontaddthistogit;
import com.google.gson.Gson;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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

    @RequestMapping(value = "/sendMessage/{msg}", method = RequestMethod.GET)
    public void sendMessage(@PathVariable("msg") String msg) throws IOException {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
                    OkHttpClient client = new OkHttpClient();
                    JSONObject json=new JSONObject();
                    JSONObject dataJson=new JSONObject();
                    dataJson.put("body",msg);
                    dataJson.put("title","random title");
                    json.put("notification",dataJson);
                    json.put("to",dontaddthistogit.androidKey);
                    com.squareup.okhttp.RequestBody body = com.squareup.okhttp.RequestBody.create(JSON,json.toString());
                    Request request = new Request.Builder()
                            .header("Authorization", dontaddthistogit.firebaseSrvKey)
                            .url("https://fcm.googleapis.com/fcm/send")
                            .post(body)
                            .build();
        client.newCall(request).execute();
    }
}
