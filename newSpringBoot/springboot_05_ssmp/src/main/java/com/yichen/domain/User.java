package com.yichen.domain;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@TableName("user")
public class User {
    private int id;
    private String username;
    private String password;
}
