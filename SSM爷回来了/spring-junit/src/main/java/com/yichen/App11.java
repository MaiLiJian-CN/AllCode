package com.yichen;

import com.yichen.Dao.AccountDao;
import com.yichen.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class App11 {
    public static void main(String[] args) throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream resource = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(resource);
        SqlSession sqlSession = sessionFactory.openSession();
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        List<Account> accountList = mapper.findAll();
        accountList.forEach(System.out::println);

        sqlSession.close();
    }
}
