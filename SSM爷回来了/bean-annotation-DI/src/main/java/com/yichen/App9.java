package com.yichen;

import com.yichen.config.SpringConfig;
import com.yichen.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App9 {
    public static void main(String[] args) {
        ApplicationContext ctx= new AnnotationConfigApplicationContext(SpringConfig.class);
        BookService bookService = ctx.getBean(BookService.class);
        bookService.save();
    }
}
