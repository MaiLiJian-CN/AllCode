package com.yichen.service.Impl;

import com.yichen.controller.Code;
import com.yichen.dao.BookDao;
import com.yichen.domain.Book;
import com.yichen.excpet.BusinessException;
import com.yichen.excpet.SystemException;
import com.yichen.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    public boolean save(Book book) {
        bookDao.save(book);
        return true;
    }

    public boolean update(Book book) {
        bookDao.update(book);
        return true;
    }

    public boolean delete(Integer id) {
        bookDao.delete(id);
        return true;
    }

    public Book getById(Integer id) {
        if (id==1) {
            throw new BusinessException(Code.BUSINESS_ERR,"别搞我");
        }
        try {
            int i= 1/0;
        }catch (Exception e){
            throw new SystemException(Code.SYSTEM_ERR,"响应超时");
        }

        return bookDao.getById(id);
    }

    public List<Book> getAll() {
//        List<Book> bookList=bookDao.getAll();
        return bookDao.getAll();
    }
}
