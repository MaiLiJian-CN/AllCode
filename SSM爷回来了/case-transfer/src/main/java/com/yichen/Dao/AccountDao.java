package com.yichen.Dao;

import com.yichen.domain.Account;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AccountDao {

    @Update("update tbl_account set money=money+ #{money} where name=#{name}")
    void inMoney(@Param("name") String name,@Param("money") Integer money);

    @Update("update tbl_account set money=money- #{money} where name=#{name}")
    void outMoney(@Param("name") String name,@Param("money") Integer money);
}
