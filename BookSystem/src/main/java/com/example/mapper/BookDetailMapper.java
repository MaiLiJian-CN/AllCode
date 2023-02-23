package com.example.mapper;

import com.example.pojo.BookDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookDetailMapper {
    @Select("select * from book_detail")
    List<BookDetail> BookDetailList();
}
