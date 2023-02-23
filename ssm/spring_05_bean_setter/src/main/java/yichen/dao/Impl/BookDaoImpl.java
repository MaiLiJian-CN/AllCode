package yichen.dao.Impl;

import yichen.dao.BookDao;

public class BookDaoImpl implements BookDao {
    private int connectionNumber;
    public void save() {
        System.out.println("book dao save "+connectionNumber);
    }

    public void setConnectionNumber(int connectionNumber) {
        this.connectionNumber = connectionNumber;
    }
}
