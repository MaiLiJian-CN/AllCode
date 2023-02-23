package com.yichen.test.json;

import com.alibaba.fastjson.JSON;
import com.yichen.pojo.User;

public class FastJsonDemo {
    public static void main(String[] args) {
        //将Java对象转化为JSON字符串
        User user=new User();
        user.setId(1);
        user.setUsername("zhangsan");
        user.setPassword("123");
        String jsonString = JSON.toJSONString(user);
        System.out.println(jsonString);

        //将JSON转化成Java代码
        User user1 = JSON.parseObject("{\"id\":1,\"password\":\"123\",\"username\":\"zhangsan\"}", User.class);
        System.out.println(user1);
    }
}
