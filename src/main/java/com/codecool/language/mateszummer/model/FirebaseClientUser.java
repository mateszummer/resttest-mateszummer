package com.codecool.language.mateszummer.model;

import javax.persistence.*;

@Entity
@Table(name = "firebaseClient")
public class FirebaseClientUser {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;

    private Integer table;
    private String appKey;

    public Integer getTable() {
        return table;
    }

    public void setTable(Integer table) {
        this.table = table;
    }

    public String getAppKey() {
        return appKey;
    }


    public FirebaseClientUser(){}

    public FirebaseClientUser(Integer table, String appKey) {
        this.table = table;
        this.appKey = appKey;
    }
}
