package com.yichen.service;

import com.yichen.domain.Account;

import java.util.List;

public interface AccountService {
    void save(Account account);
    void delete(Integer id);
    void update(Account account);
    Account findById(Integer id);
    List<Account> findAll();
}
