package com.codecool.language.mateszummer.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pub {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "categories_and_pubs",joinColumns = @JoinColumn(name = "pub_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id") )
    private List<Category> categoriesForPub;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "pub_and_pubuser", joinColumns = @JoinColumn(name = "pub_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "pubuser_id", referencedColumnName = "id"))
    private List<PubUser> pubUsers;

    @OneToMany
    private List<PubTable> pubTables;


    public List<PubUser> getPubUsers() {
        return pubUsers;
    }

    public void setPubUsers(List<PubUser> pubUsers) {
        this.pubUsers = pubUsers;
    }

    public List<PubTable> getPubTables() {
        return pubTables;
    }

    public void setPubTables(List<PubTable> pubTables) {
        this.pubTables = pubTables;
    }

    public List<Category> getCategoriesForPub() {
        return categoriesForPub;
    }

    public void setCategoriesForPub(List<Category> categoriesForPub) {
        this.categoriesForPub = categoriesForPub;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
