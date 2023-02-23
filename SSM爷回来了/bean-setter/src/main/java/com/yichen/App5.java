package com.yichen;


import com.yichen.dao.BookDao;
import com.yichen.dao.impl.BookDaoImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App5 {
    public static void main(String[] args) {
        /*获取IOC容器*/
        ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        BookDao bookDao = ctx.getBean("BookDao", BookDaoImpl.class);
        bookDao.save();
    }
}
