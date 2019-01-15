package com.tpfilms.tpfilms.controller;

import com.tpfilms.tpfilms.domain.*;
import com.tpfilms.tpfilms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin
@RequestMapping(path="/films") // This means URL's start with /demo (after Application path)
public class FilmController {

    final private FilmDao filmDao;

    final private DirectorDao directorDao;

    final private CastingDao castingDao;

    final private ActorDao actorDao;

    final private CategoryDao categoryDao;

    @Autowired
    public FilmController(FilmDao filmDao, DirectorDao directorDao, CastingDao castingDao, ActorDao actorDao, CategoryDao categoryDao) {
        this.filmDao = filmDao;
        this.directorDao = directorDao;
        this.castingDao = castingDao;
        this.actorDao = actorDao;
        this.categoryDao = categoryDao;
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

    @PutMapping(value = "")
    public ResponseEntity putRequest(@RequestBody Film film) {
        System.out.println(film);

        List<Casting> castings = film.getCasting();
        Optional<Director> director = directorDao.findById(film.getDirector().getId());
        film.setDirector(director.get());

        Category category = categoryDao.findById(film.getCategory().getId());
        film.setCategory(category);


        filmDao.save(film);

    return ResponseEntity.ok().build();
    }



    @PostMapping(path = "/new")
    public ResponseEntity<String> addFilm (@RequestBody Film film, HttpEntity<String> httpEntity) {


        String json = httpEntity.getBody();
        System.out.print(json);


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

    @DeleteMapping(path="/{id}")
    public ResponseEntity deleteMovie(@PathVariable int id) {
        filmDao.deleteById(id);
        return ResponseEntity.ok().build();
    }

}