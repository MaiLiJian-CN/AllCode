package com.yichen;


import com.yichen.dao.BookDao;
import com.yichen.dao.impl.BookDaoImpl;
import com.yichen.service.impl.BookServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App2 {
    public static void main(String[] args) {
        /*获取IOC容器*/
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        BookDao bookDao = ctx.getBean("BookDao", BookDaoImpl.class);
        bookDao.save();
        BookServiceImpl bookService1 = ctx.getBean("BookService", BookServiceImpl.class);
        BookServiceImpl bookService2 = ctx.getBean("service", BookServiceImpl.class);
//        bookService.save();
//        System.out.println(bookService1);
//        System.out.println(bookService2);
    }
}
