package com.tpfilms.tpfilms.domain;


import javax.persistence.*;

@Entity
public class Category {

    @Id
    @Column(nullable = false, name = "id")
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

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
