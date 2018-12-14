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

@Controller
@RequestMapping(path="/films") // This means URL's start with /demo (after Application path)
public class FilmController {

    final FilmDao filmDao;

    @Autowired
    public FilmController(FilmDao filmDao) {
        this.filmDao = filmDao;
    }

    /* Get requests */


    @GetMapping(path="/")
    @ResponseBody
    public Iterable<Film> getAllFilms() {
        return filmDao.findAll();
    }


    @GetMapping(value = "/{id}")
    @ResponseBody
    public Film byId(@PathVariable int id){
        return filmDao.findById(id);
    }

    /*@GetMapping(value = "/{id}/")
    @ResponseBody
    public Film byId(@PathVariable int id){
        return filmDao.findById(id);
    }*/



    /*@GetMapping(value = "/{id}/director")
    @ResponseBody
    public Director getDIRECTOR(@PathVariable int id){
        Film film = filmDao.findById(id);

        return film.getDirector();
    }*/

    /*@GetMapping(value = "/{id}/director")
    @ResponseBody
    public Director getDirector(@PathVariable int id) {
        Film film =filmDao.findById(id);
        Director director = film.getDirector();

        System.out.println(film);
        System.out.println(director);

        return new Director("eee", "eeerr");
    }*/

    /*@GetMapping(value = "/{id}/categorie")
    @ResponseBody
    public Category getCategorie(@PathVariable int id) {
        return filmDao.findById(id).getCategory();
    }*/


    /*@GetMapping(path = "/recipes/{id}")
    private ResponseEntity<Recipe> recipe(@PathVariable int id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if(recipe.isPresent()) {
            return ResponseEntity.accepted().body(recipe.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/




}