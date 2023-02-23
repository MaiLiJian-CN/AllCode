package com.yichen;


import com.yichen.service.BookService;
import com.yichen.service.Impl.BookServiceImpl;

public class App {
    public static void main(String[] args) {
        BookService bookService = new BookServiceImpl();
        bookService.save();
    }
}
