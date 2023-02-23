package yichen;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import yichen.config.SpringConfig;
import yichen.dao.BookDao;

public class appForAnnotation {
    public static void main(String[] args) {
//        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml.bak");
        /*加载配置类*/
        ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
        System.out.println(bookDao);
        bookDao.save();
    }
}
