package com.tpfilms.tpfilms.service;

import com.tpfilms.tpfilms.domain.Actor;
import com.tpfilms.tpfilms.domain.Casting;
import com.tpfilms.tpfilms.domain.CastingId;
import com.tpfilms.tpfilms.domain.Film;
import javassist.expr.Cast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CastingDao extends JpaRepository<Casting, Integer> {

    List<Casting> findAllByActor(Actor actor);

    List<Casting> findAllByFilm(Film film);

    Casting findAllByActorAndFilm(Actor actor, Film film);

    void deleteByFilm(Film film);

    void deleteByActor(Actor actor);

}

