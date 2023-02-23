package com.yichen.controller;

import com.yichen.domain.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    static List<Book> bookList=new ArrayList<Book>();
    static {
        Book b1=new Book(1,"计算机","SpringMVC入门","牛刀小试");
        Book b2=new Book(2,"计算机","SpringMVC实战","一代宗师");
        bookList.add(b1);
        bookList.add(b2);
    }


    @PostMapping
    public String save(@RequestBody Book book){
        System.out.println("book save====>"+book);
        bookList.add(book);
        return "{'module':'book save success'}";
    }

    @GetMapping
    public List<Book> getAll(){
        return bookList;
    }

}
