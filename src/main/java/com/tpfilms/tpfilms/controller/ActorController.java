package com.tpfilms.tpfilms.controller;


import com.tpfilms.tpfilms.domain.Actor;
import com.tpfilms.tpfilms.domain.Casting;
import com.tpfilms.tpfilms.domain.Film;
import com.tpfilms.tpfilms.service.ActorDao;
import com.tpfilms.tpfilms.service.CastingDao;
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
    private final CastingDao castingDao;

    @Autowired
    public ActorController(ActorDao actorDao, CastingDao castingDao) {
        this.actorDao = actorDao;
        this.castingDao = castingDao;
    }

    /* Get requests */
    @GetMapping(path="")
    public Iterable<Actor> getAll(){
        return actorDao.findAll();
    }

    @GetMapping(path="/{id}")
    public Actor getOne(@PathVariable int id){
        return actorDao.findById(id);
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

    @Transactional
    @DeleteMapping(path="/remove/{id}")
    public ResponseEntity deleteActor(@PathVariable int id) {

        Actor actor = actorDao.findById(id);
        System.out.println(actor);

        //castingDao.deleteByActor(actor);
        //actor.setCasting(null);

        actorDao.delete(actor);

        return ResponseEntity.ok().build();
    }

}
