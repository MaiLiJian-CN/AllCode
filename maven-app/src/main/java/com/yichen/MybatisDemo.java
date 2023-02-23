package com.yichen;

import com.yichen.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisDemo {
    public static void main(String[] args) throws Exception {
        //加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取sqlSession对象 用它执行sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行sql
        List<User> user = sqlSession.selectList("mybatis.selectAll");

        System.out.println(user);

        //释放资源
        sqlSession.close();
    }
}
