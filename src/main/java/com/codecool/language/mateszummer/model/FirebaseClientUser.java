package com.codecool.language.mateszummer.model;

import javax.persistence.*;

@Entity
@Table(name = "firebaseClient")
public class FirebaseClientUser {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;

    private Integer tableKey;
    private String appKey;

    public Integer getTableKey() {
        return tableKey;
    }

    public void setTableKey(Integer tableKey) {
        this.tableKey = tableKey;
    }

    public String getAppKey() {
        return appKey;
    }


    public FirebaseClientUser(){}

    public FirebaseClientUser(Integer tableKey, String appKey) {
        this.tableKey = tableKey;
        this.appKey = appKey;
    }
}
