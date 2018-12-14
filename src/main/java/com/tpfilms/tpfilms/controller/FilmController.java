package com.tpfilms.tpfilms.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tpfilms.tpfilms.domain.Casting;
import com.tpfilms.tpfilms.domain.Category;
import com.tpfilms.tpfilms.domain.Director;
import com.tpfilms.tpfilms.domain.Film;
import com.tpfilms.tpfilms.service.CastingDao;
import com.tpfilms.tpfilms.service.FilmDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/films") // This means URL's start with /demo (after Application path)
public class FilmController {

    final FilmDao filmDao;

    @Autowired
    public FilmController(FilmDao filmDao) {
        this.filmDao = filmDao;
    }

    /* Get requests */

    @GetMapping(path="")
    public Iterable<Film> getAllFilms() {
        return filmDao.findAll();
    }


    @GetMapping(value = "/{id}")
    public Film byId(@PathVariable int id){
        return filmDao.findById(id);
    }


    /* Put requests */

    @PutMapping(path = "/update")
    public Film updateFilm (@RequestBody Film film) {
        return filmDao.save(film);
    }

    /* Delete Requests */

    @DeleteMapping(path = "/remove")
    public void removeFilm(@RequestBody Film film) {
        filmDao.delete(film);
    }


}