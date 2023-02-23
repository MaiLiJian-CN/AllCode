package com.yichen;


import com.yichen.dao.BookDao;
import com.yichen.dao.impl.BookDaoImpl;
import com.yichen.service.impl.BookServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        /*获取IOC容器*/
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        BookDao bookDao = ctx.getBean("BookDao", BookDaoImpl.class);
//        bookDao.save();
        BookServiceImpl bookService = ctx.getBean("BookService", BookServiceImpl.class);
        bookService.save();

    }
}
