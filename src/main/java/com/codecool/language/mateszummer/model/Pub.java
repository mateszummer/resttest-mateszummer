package com.codecool.language.mateszummer.model;

import javax.persistence.*;

@Entity
public class Pub {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToMany
    private User user;
}
