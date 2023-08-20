package com.kmosi.dns.sys.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2023-08-13 12:53
 * @description
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("AliYun域名解析(AliYun-DNS)")
                        .version("1.0")
                        .contact(new Contact().name("阡陌兮"))
                        .description("该系统只限于内部使用，请勿外传！")
                        .termsOfService("http://127.0.0.1")
                        .license(new License().name("Apache 2.0")
                                .url("http://127.0.0.1")));
    }
}

