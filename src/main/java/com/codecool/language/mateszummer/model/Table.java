package com.codecool.language.mateszummer.model;

import javax.persistence.*;

@Entity
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToOne
    private Pub pub;
}
