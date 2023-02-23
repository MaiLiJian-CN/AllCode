package com.yichen.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    @Value("${basedir}")
    private String dir;

    @GetMapping
    public String getById() {
        System.out.println("springboot run");
        System.out.println(dir);
        return "springboot book";
    }
}
