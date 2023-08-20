package com.kmosi.dns.common.domain.meta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2023-08-12 21:19
 * @description 阿里云相关初始配置
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "ali.yun")
@Component
public class AliYunMeta {
    /**
     * 身份accessKeyId
     */
    private String accessKeyId;
    /**
     * 身份accessKeyId
     */
    private String accessKeySecret;
    /**
     * 接入点地址
     */
    private String endpoint;
    /**
     * IP获取地址
     */
    private String ipAddress;
}
