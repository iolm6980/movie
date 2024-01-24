package com.example.movie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movie")
public class MovieController {
    @GetMapping("/test")
    public void test(){
        System.out.println("test.............................");
    }

    @GetMapping("/list")
    public void list(){

    }
}
