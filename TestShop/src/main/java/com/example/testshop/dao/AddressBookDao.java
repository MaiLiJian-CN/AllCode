package com.example.testshop.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yichen.entity.AddressBook;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressBookDao extends BaseMapper<AddressBook> {
}
