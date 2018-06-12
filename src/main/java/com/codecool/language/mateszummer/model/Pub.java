package com.codecool.language.mateszummer.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pub {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToMany
    private List<User> users;

    @OneToMany
    private List<Table> tables;
}
