package yichen;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import yichen.dao.BookDao;
import yichen.service.BookService;

public class AppForLifeCycle {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
        bookDao.save();
        ctx.registerShutdownHook();

    }
}
