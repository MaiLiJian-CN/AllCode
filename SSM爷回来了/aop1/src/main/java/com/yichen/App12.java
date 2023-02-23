package com.yichen;

import com.yichen.config.SpringConfig;
import com.yichen.dao.BookDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App12 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookDao bookDao = ctx.getBean("bookDao", BookDao.class);
        bookDao.save();
        bookDao.update();
    }
}
