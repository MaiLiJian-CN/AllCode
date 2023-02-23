package com.yichen.service;

import com.yichen.domain.Account;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AccountService {
    @Transactional
    void transfer(String outName,String inName,Integer money);
}
