package yichen;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import yichen.dao.BookDao;

public class AppForScope {
    public static void main(String[] args) {
        /*获取IoC容器*/
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");

        BookDao  bookDao1 = (BookDao) ctx.getBean("bookDao");
        BookDao  bookDao2 = (BookDao) ctx.getBean("bookDao");

        System.out.println(bookDao1);
        System.out.println(bookDao2);
    }
}
