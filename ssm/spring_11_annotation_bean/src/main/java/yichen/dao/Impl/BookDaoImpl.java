package yichen.dao.Impl;

import org.springframework.stereotype.Component;
import yichen.dao.BookDao;


@Component("bookDao")
public class BookDaoImpl implements BookDao {
    public void save() {
        System.out.println("book dao save ");
    }
}
