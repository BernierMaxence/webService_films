package com.tpfilms.tpfilms.controller;


import com.tpfilms.tpfilms.domain.*;
import com.tpfilms.tpfilms.service.ActorDao;
import com.tpfilms.tpfilms.service.CastingDao;
import com.tpfilms.tpfilms.service.FilmDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path="/actors")
public class ActorController {

    private final ActorDao actorDao;
    private final FilmDao filmDao;
    private final CastingDao castingDao;

    @Autowired
    public ActorController(ActorDao actorDao, FilmDao filmDao, CastingDao castingDao) {
        this.actorDao = actorDao;
        this.filmDao = filmDao;
        this.castingDao = castingDao;
    }

    /* Get requests */
    @GetMapping(path="")
    public Iterable<Actor> getAll()
    {
        List<Actor> actors =actorDao.findAll();
        return actors;
    }

    @GetMapping(path="/{id}")
    public Actor getOne(@PathVariable int id){
        Actor actor= actorDao.findById(id);
        return actor;
    }

    @GetMapping(path = "/search")
    public Iterable<Actor> getSearchResults(@RequestParam("word") String word) {

        List<Actor> actors = new ArrayList<>();
        actors.addAll(actorDao.findAllByFirstName(word));
        actors.addAll(actorDao.findAllByLastName(word));
        return actors;

    }

    /* Put requests */
    @PutMapping(path = "/update")
    public Actor updateAndSaveActor(@RequestBody Actor actor) {

        List<Casting> casting = castingDao.findAllByActor(actor);

        actor.setCasting(casting);

        return actorDao.save(actor);
    }

    @PutMapping(path="")
    public ResponseEntity<Object> addActor(@RequestBody Actor actor) {



        System.out.println("Recived actor "+actor);
        actor.setCasting(new ArrayList<>());

        actorDao.save(actor);
        System.out.println("Saving actor "+actor);
        return ResponseEntity.ok().build();
    }

    @Transactional
    @DeleteMapping(path="/remove/{id}")
    public ResponseEntity deleteActor(@PathVariable int id) {

        Actor actor = actorDao.findById(id);

        actorDao.delete(actor);

        return ResponseEntity.ok().build();
    }

}
