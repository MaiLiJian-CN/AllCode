package com.yichen.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import javax.annotation.Resource;
import java.awt.print.Book;

@Mapper
public interface BookDao {

    @Select("select * from user where id = #{id}")
    public Book getById(int id);

}
