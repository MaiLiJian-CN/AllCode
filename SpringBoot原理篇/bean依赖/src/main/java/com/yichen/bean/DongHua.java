package com.yichen.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@EnableConfigurationProperties(DongHua.class)
@ConfigurationProperties(prefix = "dh")
public class DongHua {
    private Cat cat;
    private Mouse mouse;

    public void play(){
        System.out.println(cat.getName()+"和"+mouse.getName()+"打架");
    }
}
