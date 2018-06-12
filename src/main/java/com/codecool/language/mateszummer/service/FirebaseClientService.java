package com.codecool.language.mateszummer.service;

import com.codecool.language.mateszummer.repository.FirebaseClientUserRepository;
import com.codecool.language.mateszummer.model.FirebaseClientUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirebaseClientService {

    @Autowired
    FirebaseClientUserRepository firebaseClientUserRepository;

    public void regUser(Integer table, String apiKey) {
        firebaseClientUserRepository.save(new FirebaseClientUser(table, apiKey));
    }}
