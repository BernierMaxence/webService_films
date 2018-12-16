package com.tpfilms.tpfilms.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tpfilms.tpfilms.domain.Casting;
import com.tpfilms.tpfilms.domain.Category;
import com.tpfilms.tpfilms.domain.Director;
import com.tpfilms.tpfilms.domain.Film;
import com.tpfilms.tpfilms.service.CastingDao;
import com.tpfilms.tpfilms.service.CategoryDao;
import com.tpfilms.tpfilms.service.FilmDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@CrossOrigin(maxAge = 3600)
@RequestMapping(path="/categories") // This means URL's start with /demo (after Application path)
public class CategoryController {

    final CategoryDao categoryDao;

    @Autowired
    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    /* Get requests */


    @GetMapping(path="/")
    @ResponseBody
    public Iterable<Category> getAllCategories() {
        return categoryDao.findAll();
    }


}