package com.example.mybatisdemo1;

import com.example.mybatisdemo1.mapper.UserMapper;
import com.example.mybatisdemo1.pojo.User;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MyBatisDemo1ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserMapper userMapper;

    @Test
    void testSelectList(){
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    void TestInsert(){
        User user = new User();
        user.setAge(18);
        user.setName("麦立健");
        user.setEmail("2933004278@qq.com");
        int insert = userMapper.insert(user);
        Assertions.assertEquals(1,insert);
        System.out.println("id:"+user.getId());
    }

    @Test
    void TestDelete(){
        /*通过Id删除数据*/
//        int rs = userMapper.deleteById(1567414049203855361L);
//        Assertions.assertEquals(1,rs);

        /*通过map删除数据*/
//        Map<String,Object> map=new HashMap<>();
//        map.put("name","麦立健");
//        map.put("age",18);
//        int rs = userMapper.deleteByMap(map);
//        Assertions.assertEquals(1,rs);
        int i = userMapper.deleteBatchIds(Arrays.asList(1L, 2L));
        Assertions.assertEquals(2,i);
    }
}
