package com.tpfilms.tpfilms.controller;

import com.tpfilms.tpfilms.domain.Category;
import com.tpfilms.tpfilms.domain.Director;
import com.tpfilms.tpfilms.domain.Film;
import com.tpfilms.tpfilms.service.CategoryDao;
import com.tpfilms.tpfilms.service.DirectorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AppController {
    final
    CategoryDao categoryDao;
    @Autowired
    DirectorDao directorDao;

    @Autowired
    public AppController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }


    @GetMapping(path="/categories")
    public Iterable<Category>  getAllCategorie(){
        return categoryDao.findAll();
    }

    @GetMapping(path="/directors")
    public Iterable<Director>  getAllDirectors(){
        return directorDao.findAll();
    }



}
