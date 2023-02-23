package yichen;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import yichen.service.BookService;

public class AppForLifeCycle {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");

        ctx.registerShutdownHook();
        BookService bookService = (BookService) ctx.getBean("bookService");
        bookService.save();
    }
}
