package com.example.electronicbusinessplatform.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping("/")
    public String test(){
        System.out.println("Hi");
        return "Hollo world";
    }

}
