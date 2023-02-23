package com.yichen;

import com.yichen.bean.DongHua;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App1 {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(App1.class, args);
        DongHua dongHua = (DongHua) ctx.getBean("dongHua");
        dongHua.play();
    }
}
