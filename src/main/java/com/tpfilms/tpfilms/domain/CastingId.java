package com.tpfilms.tpfilms.domain;



import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CastingId implements Serializable {


    @Column(name = "id_film")
    private int film;

    @Column(name = "id_actor", insertable=false ,updatable=false)
    private int actor;


    public CastingId() {

    }

    public int getActor() {
        return actor;
    }

    public int getFilm() {
        return film;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CastingId castingId = (CastingId) o;
        return Objects.equals(getFilm(), castingId.getFilm()) &&
                Objects.equals(getActor(), castingId.getActor());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getFilm(), getActor());
    }
}



