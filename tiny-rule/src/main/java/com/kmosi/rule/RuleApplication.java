package com.kmosi.rule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2022-11-26 11:03
 * @description 启动器
 */
@SpringBootApplication
@Slf4j
public class RuleApplication {
    public static void main(String[] args) {
        log.info("程序开始启动······");
        ConfigurableApplicationContext context = SpringApplication.run(RuleApplication.class, args);
        Environment env = context.getBean(Environment.class);
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");
        log.info("程序完成启动······请访问：{}:{}{}", "http://127.0.0.1", port == null ? 8080 : port, path == null ? "" : path);
    }
}
