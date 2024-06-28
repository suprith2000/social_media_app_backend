package com.social.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @GetMapping
    public String homeControllerHandler(){
        return "this is homeControllerHandler";
    }

    @GetMapping("/home1")
    public String homeControllerHandler1(){
        return "this is homeControllerHandler 1";
    }

    @GetMapping("/home2")
    public String homeControllerHandler2(){
        return "this is homeControllerHandler 2";
    }
//    @PostMapping
//    @DeleteMapping
//    @PutMapping
}
