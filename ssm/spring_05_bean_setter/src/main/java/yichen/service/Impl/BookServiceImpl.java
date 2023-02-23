package yichen.service.Impl;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import yichen.dao.BookDao;
import yichen.dao.UserDao;
import yichen.service.BookService;

public class BookServiceImpl implements BookService, InitializingBean, DisposableBean {
    private UserDao userDao;
    private BookDao bookDao;

    public void save() {
        System.out.println("book service save");
        bookDao.save();
        userDao.save();
    }
    public void setBookDao(BookDao bookDao){
        this.bookDao=bookDao;
    }

    public void setUserDao(UserDao userDao){
        this.userDao=userDao;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("====destroy====");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("====init====");
    }
}
