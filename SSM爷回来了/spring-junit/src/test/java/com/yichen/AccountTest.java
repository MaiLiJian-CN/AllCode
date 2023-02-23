package com.yichen;

import com.yichen.config.SpringConfig;
import com.yichen.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class AccountTest {
    @Autowired
    private AccountService accountService;

    @Test
    public void findAll(){
        accountService.findAll().forEach(System.out::println);
    }
}
