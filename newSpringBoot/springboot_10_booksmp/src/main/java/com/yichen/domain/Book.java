package com.yichen.domain;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("book")
public class Book {
    private int id;
    private String name;
    private String type;
    private String description;
}
