package com.yichen.dao1;

import com.yichen.domin.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookDao {

    @Select("select * from user where id = #{id}")
    public Book getById(int id);

}
