package Test;

import com.yichen.mybatis.mapper.UserMapper;
import com.yichen.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

public class insertUserTest {
    @Test
    public void TestUserCURD() throws IOException {
        //加载配置文件
        InputStream resource = Resources.getResourceAsStream("mybatis-config.xml");
        //获取sqlSessionFactoryBuilder
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = builder.build(resource);
        //获取SqlSession
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//自动提交事务
        //获取mapper接口对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        int rs = mapper.insertUser();
//        int i = mapper.deleteUser();
//        int i1 = mapper.updateUser();
//        User user = mapper.selectUser();
        /*提交事务*/
//        sqlSession.commit();
        List<User> userList = mapper.selectAllUser();
        userList.forEach(System.out::println);
    }

}
