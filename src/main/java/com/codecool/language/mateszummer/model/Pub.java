package com.codecool.language.mateszummer.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pub {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private List<PubUser> pubUsers;

    @OneToMany
    private List<PubTable> pubTables;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Pub_and_PubUser", joinColumns = @JoinColumn(name = "pub_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "pubuser_id", referencedColumnName = "id"))
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
}
