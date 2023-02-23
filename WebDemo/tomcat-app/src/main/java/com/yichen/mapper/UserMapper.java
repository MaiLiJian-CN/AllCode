package com.yichen.mapper;

import com.yichen.pojoTest.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import javax.jws.soap.SOAPBinding;

public interface UserMapper {
    @Select("select * from tb_user where username = #{username} and passowrd = #{password}")
    User select(@Param("username") String username,@Param("password") String password);

    @Select("select * from tb_user where username=#{username}")
    User selectByName(@Param("username") String username);

    @Insert("insert into tb_user values (null,#{username},#{password})")
    void add(User user);
}
