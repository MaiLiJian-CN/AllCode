package com.example.mybatisdemo1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisdemo1.pojo.User;
import org.springframework.stereotype.Repository;
/*标志为持久层*/
@Repository
public interface UserMapper extends BaseMapper<User> {
}
