package yichen.service.Impl;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yichen.dao.BookDao;
import yichen.service.BookService;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    public void save() {
        bookDao.save();

    }
    public void setBookDao(BookDao bookDao){
        this.bookDao=bookDao;
    }

}
