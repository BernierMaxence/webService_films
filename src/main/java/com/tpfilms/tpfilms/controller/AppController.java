package com.tpfilms.tpfilms.controller;

import com.tpfilms.tpfilms.domain.Category;
import com.tpfilms.tpfilms.service.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    final
    CategoryDao categoryDao;

    @Autowired
    public AppController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }


    @GetMapping(path="/categories")
    public Iterable<Category>  getAllCategorie(){
        return categoryDao.findAll();
    }


}
