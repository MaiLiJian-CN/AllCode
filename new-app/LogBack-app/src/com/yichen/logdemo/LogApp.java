package com.yichen.logdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogApp {
    public static final Logger LOGGER = LoggerFactory.getLogger("LogApp");
    public static void main(String[] args) {
        try {
            LOGGER.debug("main开始运行");
            LOGGER.info("main正在算数计算");
            int a=10;
            int b=0;
            LOGGER.trace("a=" +a);
            LOGGER.trace("b=" +b);

            System.out.println(a / b);
        } catch (Exception e) {
//            e.printStackTrace();
            LOGGER.error("有错误");
        }
    }
}
