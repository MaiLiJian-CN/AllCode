package com.yichen;


import com.yichen.dao.BookDao;
import com.yichen.dao.impl.BookDaoImpl;
import com.yichen.service.impl.BookServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App4 {
    public static void main(String[] args) {
        /*获取IOC容器*/
        ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        ctx.registerShutdownHook();
        BookDao bookDao = ctx.getBean("BookDao", BookDaoImpl.class);
        bookDao.save();
//        ctx.close();//暴力关闭容器
    }
}
