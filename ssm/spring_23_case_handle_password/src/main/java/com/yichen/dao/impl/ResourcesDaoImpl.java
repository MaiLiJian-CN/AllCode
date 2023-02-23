package com.yichen.dao.impl;

import com.yichen.dao.ResourcesDao;
import org.springframework.stereotype.Repository;

@Repository
public class ResourcesDaoImpl implements ResourcesDao {

    public boolean readResources(String url, String password) {
        return password.equals("root");
    }
}
