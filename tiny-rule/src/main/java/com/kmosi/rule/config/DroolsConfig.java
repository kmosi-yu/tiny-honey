package com.kmosi.rule.config;

import org.kie.api.KieServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2022-11-26 11:04
 * @description 获取kieServices
 */
@Configuration
public class DroolsConfig {
    @Bean
    KieServices kieServices() {
        return KieServices.get();
    }
}
