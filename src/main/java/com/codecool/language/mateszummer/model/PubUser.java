package com.codecool.language.mateszummer.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// Here we are going to store, do stuff with the people who are managing the pubs(owners admins etc)
@Entity
public class PubUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @ManyToMany(mappedBy = "pubUsers")
    private List<Pub> pubs = new ArrayList<>();
}
