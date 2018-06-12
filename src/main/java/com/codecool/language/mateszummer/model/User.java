package com.codecool.language.mateszummer.model;


import javax.persistence.*;
import java.util.List;

// Here we are going to store, do stuff with the people who are managing the pubs(owners admins etc)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToMany
    private List<Pub> pubs;
}
