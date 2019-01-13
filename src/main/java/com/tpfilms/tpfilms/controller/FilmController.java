package com.tpfilms.tpfilms.controller;

import com.tpfilms.tpfilms.domain.*;
import com.tpfilms.tpfilms.service.ActorDao;
import com.tpfilms.tpfilms.service.CastingDao;
import com.tpfilms.tpfilms.service.FilmDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping(path="/films") // This means URL's start with /demo (after Application path)
public class FilmController {

    final FilmDao filmDao;

    final CastingDao castingDao;

    final ActorDao actorDao;

    @Autowired
    public FilmController(FilmDao filmDao, CastingDao castingDao, ActorDao actorDao) {
        this.filmDao = filmDao;
        this.castingDao = castingDao;
        this.actorDao = actorDao;
    }
    
    @GetMapping(path="")
    public Iterable<Film> getAllFilms() {

        return filmDao.findAll();
        //return castingDao.findAll();
    }

    @GetMapping(value = "/{id}")
    public Film byId(@PathVariable int id){
        return filmDao.findById(id);
    }

    @PostMapping(path = "/new")
    public ResponseEntity<String> addFilm (@RequestBody Film film) {


        List<Casting> castings = film.getCasting();

        film.setCasting(null);
        film = filmDao.save(film);

        int filmId = film.getId();

        for (Casting casting : castings) {
            Actor actor = actorDao.findById(casting.getId_casting().getActor());
            casting.setActor(actor);
            casting.setId_casting(new CastingId(filmId, actor.getId()));
        }

        castingDao.saveAll(castings);

        return new ResponseEntity<String>("Created", HttpStatus.CREATED);
    }



}