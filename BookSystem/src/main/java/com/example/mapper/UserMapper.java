package com.example.mapper;

import com.example.pojo.BookUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from book_user")
    List<BookUser> findAll();

    @Select("select * from book_user where username=#{username} and user_passwd=#{user_passwd}")
    BookUser selectUser(@Param("username")String username, @Param("user_passwd")String user_passwd);

}
