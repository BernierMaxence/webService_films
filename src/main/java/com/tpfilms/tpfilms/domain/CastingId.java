package com.tpfilms.tpfilms.domain;




import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Table(name = "film_actor")
public class CastingId implements Serializable {

    @Column(name = "id_film")
    private int film;

    @Column(name = "id_actor")
    private int actor;


    /*@ManyToOne
    @JoinColumn(name = "id_film")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "id_actor")
    private Actor actor;*/

    public CastingId() {
    }

    public CastingId(int film, int actor) {
        this.film = film;
        this.actor = actor;
    }

    public int getFilm() {
        return film;
    }

    public void setFilm(int film) {
        this.film = film;
    }

    public int getActor() {
        return actor;
    }

    public void setActor(int actor) {
        this.actor = actor;
    }

    @Override
    public String toString() {
        return "CastingId{" +"\n"+
                "film=" + film +"\n"+
                ", actor=" + actor +"\n"+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CastingId castingId = (CastingId) o;
        return film == castingId.film &&
                actor == castingId.actor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(film, actor);
    }
}



