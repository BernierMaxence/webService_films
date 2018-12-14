package com.tpfilms.tpfilms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping(path="/")
    public String get() {
        return "Hello world";
    }


}
