package com.yichen.server.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yichen.dao.AddressBookDao;
import com.yichen.entity.AddressBook;
import com.yichen.server.AddressBookServer;
import org.springframework.stereotype.Service;

@Service
public class AddressBookServerImpl extends ServiceImpl<AddressBookDao, AddressBook> implements AddressBookServer {
}
