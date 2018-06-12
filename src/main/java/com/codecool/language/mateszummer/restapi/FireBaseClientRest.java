package com.codecool.language.mateszummer.restapi;


import com.codecool.language.mateszummer.service.FirebaseClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FireBaseClientRest {

    @Autowired
    FirebaseClientService firebaseClientService;

    @RequestMapping(value = "/regUser", method = RequestMethod.POST)
    public void regUser(@RequestParam("table") Integer table,
                        @RequestParam("apiKey") String apiKey) {


    }
}
