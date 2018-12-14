package com.tpfilms.tpfilms.domain;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "film_actor")

public class Casting implements Serializable{

    @EmbeddedId
    @JsonIgnore
    private CastingId id_casting;

    @ManyToOne
    @JoinColumn(name = "id_actor", insertable = false, updatable = false)
    private Actor actor;


    @Column(name = "name")
    private String name;


    public Casting() {
    }

    public CastingId getId_casting() {
        return id_casting;
    }


    public Actor getActor() {
        return actor;
    }

    public String getName() {
        return name;
    }
}

