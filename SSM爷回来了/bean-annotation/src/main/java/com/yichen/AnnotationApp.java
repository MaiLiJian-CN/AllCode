package com.yichen;

import com.yichen.config.SpringConfig;
import com.yichen.dao.BookDao;
import com.yichen.dao.impl.BookDaoImpl;
import com.yichen.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationApp {
    public static void main(String[] args) {
        ApplicationContext ctx= new AnnotationConfigApplicationContext(SpringConfig.class);
        BookDao bookDao = ctx.getBean("bookDao", BookDaoImpl.class);
        System.out.println(bookDao);
        BookService bookService = ctx.getBean(BookService.class);
        System.out.println(bookService);
    }
}
