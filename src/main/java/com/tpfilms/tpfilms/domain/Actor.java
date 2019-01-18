package com.tpfilms.tpfilms.domain;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Actor implements Serializable {
    @Id
    @Column(nullable = false, name = "id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "birth_date")
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date birth_date;

    @Column(name = "death_date")
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date death_date;

    @OneToMany(mappedBy = "actor", cascade=CascadeType.ALL)
    @JsonIgnoreProperties({"id_casting", "actor"})
    private List<Casting> casting = new ArrayList<Casting>();

    private String url_image;

    public Actor() {
    }

    public List<Casting> getCasting() {
        return casting;
    }

    public void setCasting(List<Casting> casting) {
        this.casting = casting;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public Date getDeath_date() {
        return death_date;
    }

    public void setDeath_date(Date death_date) {
        this.death_date = death_date;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }


}
