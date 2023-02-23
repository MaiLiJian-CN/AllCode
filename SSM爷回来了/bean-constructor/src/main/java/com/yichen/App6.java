package com.yichen;


import com.yichen.dao.BookDao;
import com.yichen.dao.impl.BookDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App6 {
    public static void main(String[] args) {
        /*获取IOC容器*/
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        BookDao bookService = ctx.getBean("bookService", BookDao.class);
        bookService.save();

    }
}
