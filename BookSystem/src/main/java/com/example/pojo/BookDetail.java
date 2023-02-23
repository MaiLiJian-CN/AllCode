package com.example.pojo;

import lombok.Data;

import java.math.BigInteger;

@Data
public class BookDetail {
    private int id;
    private String BookName;
    private String PhotoAddress;
    private BigInteger BookPrice;
    private Integer BookNumber;
}
