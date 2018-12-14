package com.tpfilms.tpfilms.controller;


import com.tpfilms.tpfilms.domain.Actor;
import com.tpfilms.tpfilms.domain.Casting;
import com.tpfilms.tpfilms.domain.Film;
import com.tpfilms.tpfilms.service.ActorDao;
import com.tpfilms.tpfilms.service.CastingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path="/actors")
public class ActorController {

    @Autowired
     ActorDao actorDao;
    //final FilmDao filmDao;
    @Autowired
    CastingDao castingDao;

    /* Get requests */

    @GetMapping(path="")
    public Iterable<Actor> getAll(){
        return actorDao.findAll();
    }

    @GetMapping(path="/{id}")
    public Actor getOne(@PathVariable int id){
        return actorDao.findById(id);
    }

    /*@GetMapping(path="/{id}/casting")
    public Iterable<Film> getCasting(@PathVariable int id) {
        Actor actor = actorDao.findById(id);
        List<Casting> castings = castingDao.findAll();
        return null;
     /*   ArrayList<Casting> castings = new ArrayList<>(castingDao.findAllByActor(actor));
        List<Film> films =  castings.stream()
                                    .map(Casting::getFilm)
                                    .collect(Collectors.toList());
        System.out.println(films);
        return films;*/

    //}

    /* Put requests */
    @PutMapping
    public Actor updateActor(@RequestBody Actor actor) {
        return actorDao.save(actor);
    }

}
