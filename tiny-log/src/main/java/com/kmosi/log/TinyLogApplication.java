package com.kmosi.log;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2021-08-19 17:22
 * @description 启动类
 */
@SpringBootApplication
@Slf4j
public class TinyLogApplication {
    public static void main(String[] args) {
        log.info("程序开始启动······");
        ConfigurableApplicationContext context = SpringApplication.run(TinyLogApplication.class, args);
        Environment env = context.getBean(Environment.class);
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");
        log.info("程序完成启动······请访问：{}:{}{}", "http://127.0.0.1", port, path == null ? "" : path);
    }
}
