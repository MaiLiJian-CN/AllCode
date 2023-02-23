package com.example.Service.impl;

import com.example.Service.BookDetailService;
import com.example.Service.BookUserService;
import com.example.mapper.BookDetailMapper;
import com.example.pojo.BookDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookDetailServiceImpl implements BookDetailService {
    @Autowired
    private BookDetailMapper mapper;

    @Override
    public List<BookDetail> findBookDetail() {
        return mapper.BookDetailList();
    }
}
