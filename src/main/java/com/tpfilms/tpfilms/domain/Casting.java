package com.tpfilms.tpfilms.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "film_actor")
public class Casting implements Serializable{

    @EmbeddedId
    private CastingId id_casting;

    @ManyToOne
    @JoinColumn(name = "id_film", insertable=false, updatable=false)
    @JsonIgnoreProperties("casting")
    private Film film;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="id_actor",  insertable=false, updatable=false)
    @JsonIgnoreProperties("casting")
    private Actor actor;


    @Column(name = "name")
    private String name;

    public Casting() {
    }


    public CastingId getId_casting() {
        return id_casting;
    }

    public void setId_casting(CastingId id_casting) {
        this.id_casting = id_casting;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Casting{" +"\n"+
                "id_casting=" + id_casting +"\n"+
                ", actor=" + actor +"\n"+
                ", name='" + name + '\'' +
                '}';
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }


}

