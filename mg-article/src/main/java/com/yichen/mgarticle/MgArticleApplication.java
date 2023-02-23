package com.yichen.mgarticle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication
public class MgArticleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MgArticleApplication.class, args);
    }

}
