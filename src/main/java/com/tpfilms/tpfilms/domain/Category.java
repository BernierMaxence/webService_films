package com.tpfilms.tpfilms.domain;

import javax.persistence.*;

@Entity
public class Category {

    @Id
    @Column(nullable = false, name = "id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String id;

    @Column(name = "name")
    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
