package yichen.dao.factory;

import yichen.dao.BookDao;
import yichen.dao.Impl.BookDaoImpl;

public class BookDaoFactoryTwo {
    public BookDao getBookDao(){
        return new BookDaoImpl();
    }
}
