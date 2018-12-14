package com.tpfilms.tpfilms.controller;


import com.tpfilms.tpfilms.domain.Actor;
import com.tpfilms.tpfilms.service.ActorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/actors")
public class ActorController {

    final ActorDao actorDao;

    @Autowired
    public ActorController(ActorDao actorDao) {
        this.actorDao = actorDao;
    }

    @GetMapping(path="/")
    @ResponseBody
    public Iterable<Actor> getAll(){
        return actorDao.findAll();
    }

    @GetMapping(path="/{id}")
    @ResponseBody
    public Actor getOne(@PathVariable int id){
        return actorDao.findById(id);
    }
}
