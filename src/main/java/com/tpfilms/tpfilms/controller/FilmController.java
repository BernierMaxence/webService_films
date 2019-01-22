package com.tpfilms.tpfilms.controller;

import com.tpfilms.tpfilms.domain.*;
import com.tpfilms.tpfilms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin
@RequestMapping(path="/films")
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
    }

    @GetMapping(value = "/{id}")
    public Film byId(@PathVariable int id){
        return filmDao.findById(id);
    }

    @GetMapping(path = "/category/{category}")
    public Iterable<Film> getAllFilmsById(@PathVariable String category) {
        return filmDao.findAllByCategory(categoryDao.findById(category));
    }

    @GetMapping(path = "/search")
    public Iterable<Film> getSearchResults(@RequestParam("word") String word) {
        List<Film> films = new ArrayList<>();

        List<Film> filmsByDirector = filmDao.findAllByDirector(directorDao.findByLastName(word));
        List<Film> filmsByTitle = filmDao.findAllByTitle(word);


        films.addAll(filmsByDirector);
        films.addAll(filmsByTitle);

        List<Casting> castings = castingDao.findAllByActor(actorDao.findByLastName(word));
        for (Casting casting : castings) {
            films.add(casting.getFilm());
        }

        return films;
    }


    @PutMapping(value = "")
    public ResponseEntity putRequest(@RequestBody Film film) {



        // Set director
        Optional<Director> director = Optional.ofNullable(directorDao.findById(film.getDirector().getId()));
        film.setDirector(director.get());

        // Set category
        Category category = categoryDao.findById(film.getCategory().getName());
        film.setCategory(category);

        // Empty casting
        List<Casting> recivedCasting = film.getCasting();

        film.setCasting(new ArrayList<>());

        // Save film
         filmDao.save(film);

        Film f = filmDao.findByTitle(film.getTitle());
        CastingId cId;
        for (Casting c : recivedCasting) {
            c.setName("");
            c.setFilm(f);
            c.setActor(actorDao.findById(c.getActor().getId()));

            int i = f.getId();
            Actor a =c.getActor();
            int ia = a.getId();
            cId = new CastingId(i, ia);

            c.setId_casting(cId);
            castingDao.save(c);

        }

        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/update")
    public ResponseEntity updateFilm(@RequestBody Film film) {

        Film f = filmDao.findById(film.getId());
        List<Casting> casting = castingDao.findAllByFilm(f);
        film.setCasting(casting);

        Optional<Director> director = Optional.ofNullable(directorDao.findById(film.getDirector().getId()));
        film.setDirector(director.get());

        Category category = categoryDao.findById(film.getCategory().getId());
        film.setCategory(category);

        filmDao.save(film);

        return ResponseEntity.ok().build();
    }



    /*@PostMapping(path = "/new")
    public ResponseEntity<String> addFilm (@RequestBody Film film, HttpEntity<String> httpEntity) {



//        String json = httpEntity.getBody();


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

        return new ResponseEntity<>("Created", HttpStatus.CREATED);
    }*/

    @Transactional
    @DeleteMapping(path="/remove/{id}")
    public ResponseEntity deleteMovie(@PathVariable int id) {

        Film film = filmDao.findById(id);


        castingDao.deleteByFilm(film);

        film.setCasting(null);
        film.setCategory(null);
        film.setDirector(null);

        filmDao.delete(film);

        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "/casting")
    public void addCharacterToCasting(@RequestBody Casting casting) {
        castingDao.save(casting);
    }

    /*@DeleteMapping(path = "/casting")
    public void removeCharacterFromCasting(@RequestBody Casting casting) {
        Film film = filmDao.findById(casting.getId_casting().getFilm());
        casting.setFilm(film);
        Actor actor = actorDao.findById(casting.getId_casting().getActor());
        casting.setActor(actor);

        Casting c = castingDao.findAllByActorAndFilm(actor, film);

        castingDao.delete(c);
    }*/




}