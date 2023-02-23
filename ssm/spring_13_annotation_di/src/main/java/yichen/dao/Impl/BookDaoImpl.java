package yichen.dao.Impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import yichen.dao.BookDao;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Repository
@Component("bookDao")
@Scope("prototype")
public class BookDaoImpl implements BookDao {
    @Value("麦立健")
    private String name;


    public void save() {
        System.out.println("book dao save "+name);
    }

    @PostConstruct
    public void init(){
        System.out.println("init");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy");
    }
}
