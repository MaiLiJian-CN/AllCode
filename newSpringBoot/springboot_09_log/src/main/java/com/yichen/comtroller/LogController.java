package com.yichen.comtroller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/logs")
@RestController
@Slf4j
public class LogController {
    @GetMapping
    public String GetAll() {
        log.debug("debug");
        log.error("error");
        log.info("info");
        return "";
    }
}
