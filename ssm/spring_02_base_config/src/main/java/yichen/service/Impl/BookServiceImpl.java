package yichen.service.Impl;

import yichen.dao.BookDao;
import yichen.service.BookService;

public class BookServiceImpl implements BookService {
    private BookDao bookDao;

    public void save() {
        System.out.println("book service save");
        bookDao.save();
    }
    public void setBookDao(BookDao bookDao){
        this.bookDao=bookDao;
    }


}
