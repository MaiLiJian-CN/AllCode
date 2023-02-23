package yichen;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import yichen.service.BookService;

public class app {
    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml.bak");
        BookService bookService = (BookService) ctx.getBean("bookService");
//        BookDao bookDao2 = (BookDao) ctx.getBean("bookDao");
        System.out.println(bookService);
//        System.out.println(bookDao2);
//        bookDao.save();
    }
}
