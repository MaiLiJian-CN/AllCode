package com.yichen;

import com.yichen.Dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App7 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object source = context.getBean("dataSource");
        UserDao userDao = context.getBean("userDao", UserDao.class);
        userDao.save();
    }
}
