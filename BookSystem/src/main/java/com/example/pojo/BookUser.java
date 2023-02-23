package com.example.pojo;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("book_user")
public class BookUser {
    private int id;
    private String userPasswd;
    private int UserAccount;
    private String username;
}
