package com.kmosi.dns.sys.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2023-08-12 22:03
 * @description
 */
@Configuration
public class RestTemplateConfig {
    /**
     * 创建restTemplate
     *
     * @param factory ClientHttpRequestFactory
     * @return RestTemplate
     */
    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
        return new RestTemplate(factory);
    }

    /**
     * 创建okHttp3ClientHttpRequestFactory
     *
     * @return ClientHttpRequestFactory
     */
    @Bean
    public ClientHttpRequestFactory okHttp3ClientHttpRequestFactory() {
        OkHttp3ClientHttpRequestFactory factory = new OkHttp3ClientHttpRequestFactory();
        factory.setConnectTimeout(6000);
        factory.setReadTimeout(3000);
        factory.setWriteTimeout(3000);
        return factory;
    }
}
