package com.codecool.language.mateszummer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FirebaseClientUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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


    public void FirebaseClientUser(){}

    public FirebaseClientUser(Integer table, String appKey) {
        this.table = table;
        this.appKey = appKey;
    }
}
