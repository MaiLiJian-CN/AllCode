package yichen.dao.factory;

import yichen.dao.BookDao;
import yichen.dao.Impl.BookDaoImpl;

public class BoockDaoFactory {
    public static BookDao getBookDao(){
        return new BookDaoImpl();
    }
}
