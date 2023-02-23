package com.yichen;

import com.yichen.mapper.UserMapper;
import com.yichen.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MybatisDemo2 {
    public static void main(String[] args) throws Exception {
        //加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取sqlSession对象 用它执行sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行sql
//        List<User> user = sqlSession.selectList("mybatis.selectAll");
        //获取UserMapper接口的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> user = mapper.selectAll();
        System.out.println(user);

        //释放资源
        sqlSession.close();
    }
}
