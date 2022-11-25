package com.kmosi.log.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2021-06-21 16:45
 * @description
 */
@RestController
@Slf4j
public class HelloController {
    @GetMapping("hello")
    public String hello(String name){
        log.info("name:{}",name);
        log.warn("name:{}",name);
        log.debug("name:{}",name);
        log.error("name:{}",name);
        return name;
    }
}
