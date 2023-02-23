package com.yichen.service.impl;

import com.yichen.Dao.AccountDao;
import com.yichen.domain.Account;
import com.yichen.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AccountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;


    @Override
    public void transfer(String outName, String inName, Integer money) {
        accountDao.inMoney(inName,money);
        int i=1/0;
        accountDao.outMoney(outName,money);
    }
}
