package com.example.controller;


import lombok.extern.slf4j.Slf4j;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/logs")
@RestController
@Slf4j
public class LogController {
    //   private static final Logger log = LoggerFactory.getLogger(LogController.class);
    @GetMapping
    public String getById() {
        log.error("error");
        log.warn("warn");
        log.info("info");
        log.debug("debug");
        return "";
    }
}
