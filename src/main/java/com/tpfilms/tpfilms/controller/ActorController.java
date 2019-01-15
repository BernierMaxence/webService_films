package com.tpfilms.tpfilms.controller;


import com.tpfilms.tpfilms.domain.Actor;
import com.tpfilms.tpfilms.service.ActorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path="/actors")
public class ActorController {

    private final ActorDao actorDao;

    @Autowired
    public ActorController(ActorDao actorDao) {
        this.actorDao = actorDao;
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


    /* Put requests */
    @PutMapping(path = "/update")
    public Actor updateAndSaveActor(@RequestBody Actor actor) {
        return actorDao.save(actor);
    }

    /* Delete Request */
    @DeleteMapping(path = "/remove")
    public  void deleteActor(@RequestBody Actor actor) {
        actorDao.delete(actor);
    }

}
