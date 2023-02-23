package com.example.controller;

import com.example.Service.BookDetailService;
import com.example.pojo.BookDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookDetailController {
    @Autowired
    private BookDetailService service;

    @GetMapping("/bookDetail")
    public List<BookDetail> findAllBook(){
        return service.findBookDetail();
    }
}
