package com.yichen.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yichen.dao.BookDao;
import com.yichen.domain.Book;

public interface BookService extends IService<Book> {
    public IPage<Book> getPage(int currentPage, int pageSize);
}
