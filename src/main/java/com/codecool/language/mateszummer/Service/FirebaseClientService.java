package com.codecool.language.mateszummer.Service;

import com.codecool.language.mateszummer.Repository.FirebaseClientUserRepo;
import com.codecool.language.mateszummer.model.FirebaseClientUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirebaseClientService {

    @Autowired
    FirebaseClientUserRepo firebaseClientUserRepo;

    public void regUser(Integer table, String apiKey) {
        firebaseClientUserRepo.save(new FirebaseClientUser(table, apiKey));
    }}
