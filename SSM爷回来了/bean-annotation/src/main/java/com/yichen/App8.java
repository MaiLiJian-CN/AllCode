package com.yichen;


import com.yichen.dao.BookDao;
import com.yichen.dao.impl.BookDaoImpl;
import com.yichen.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App8 {
    public static void main(String[] args) {
        /*获取IOC容器*/
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml.bak");
        BookDao bookDao = ctx.getBean("bookDao", BookDaoImpl.class);
        System.out.println(bookDao);
        BookService bookService = ctx.getBean(BookService.class);
        System.out.println(bookService);
    }
}
