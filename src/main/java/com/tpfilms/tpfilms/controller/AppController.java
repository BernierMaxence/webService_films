package com.tpfilms.tpfilms.controller;

import com.tpfilms.tpfilms.domain.*;
import com.tpfilms.tpfilms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AppController {
    private final CategoryDao categoryDao;
    private final DirectorDao directorDao;
    private final FilmDao filmDao;
    private final ActorDao actorDao;
    private final CastingDao castingDao;

    @Autowired
    public AppController(CategoryDao categoryDao, DirectorDao directorDao, FilmDao filmDao, ActorDao actorDao, CastingDao castingDao) {
        this.categoryDao = categoryDao;
        this.directorDao = directorDao;
        this.filmDao = filmDao;
        this.actorDao = actorDao;
        this.castingDao = castingDao;
    }


    @GetMapping(path="/categories")
    public Iterable<Category>  getAllCategorie(){
        return categoryDao.findAll();
    }

    @GetMapping(path="/directors")
    public Iterable<Director>  getAllDirectors(){
        return directorDao.findAll();
    }

    @GetMapping(path = "/testFilms")
    public Iterable<Film> getAllFilms() {
        return  filmDao.findAll();
    }
    @GetMapping(path = "/testActors")
    public Iterable<Actor> getAllActors() {
        return  actorDao.findAll();
    }

    @GetMapping(path = "/testCastings")
    public Iterable<Casting> getAllCasting() {
        return castingDao.findAll();
    }

}
